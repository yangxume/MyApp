package he.test.okay.com.testhe.span.blank.self.watcher

import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.EditText
import he.test.okay.com.testhe.span.blank.data.OkayDataSpan
import he.test.okay.com.testhe.span.blank.data.OkayTextStyleSpan
import he.test.okay.com.testhe.span.blank.self.Blank
import he.test.okay.com.testhe.span.blank.self.BlankDataSpan
import he.test.okay.com.testhe.span.blank.watcher.SpanFactory
import he.test.okay.com.testhe.span.blank.data.OkayTextWatcher
import java.util.*
import kotlin.reflect.KClass

/**
 * @author hesongchao
 * Created on 2019/6/21 14:14
 */
class OkayBlankTextWatcher(private var editText: EditText) : TextWatcher, OkayTextWatcher {


    private var copySpanStyle = COPY_SPAN_SHOW_NONE

    constructor(editText: EditText, copySpanStyle: Int) : this(editText) {
        this.copySpanStyle = copySpanStyle
    }

    companion object {
        const val COPY_SPAN_DELETE = 1
        //copy 出来的的内容按照固定样式展示
        const val COPY_SPAN_SHOW_STYLE = 2
        //copy 出来的的内容按照固定样式展示
        const val COPY_SPAN_SHOW_NONE = 3
    }


    override fun afterTextChanged(s: Editable?) {
        //To change body of created functions use File | Settings | File Templates.
        when (copySpanStyle) {
            COPY_SPAN_DELETE, COPY_SPAN_SHOW_STYLE -> {
                textChangeSpan(copySpanStyle)
            }
            COPY_SPAN_SHOW_NONE -> {
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //To change body of created functions use File | Settings | File Templates.

        // text 变化后 校正不对应的span

    }

    private var isChangingSpan = false

    private fun textChangeSpan(copySpanStyle: Int) {
        if (isChangingSpan) return
        isChangingSpan = true
        var text = editText.text
        (text as SpannableStringBuilder).run {
            text.getSpans(0, text.length, OkayDataSpan::class.java)?.run {
                var content = text.toString()
                //筛选已删除的 blank 内容的 blankSpan 标签
                var delete = this.filterNot {
                    it is OkayDataSpan && contains(content, it, text)
                }

                //删除 多余的不展示的blank 标签
                deleteUnnecessaryBlankSpan(delete, text)

                //获取正常展示的 blank 标签 并且按照角标重新排序的集合
                var showSpan = (this, content, text)
                //按照设置模式，来处理 多余符合blank 标签 的非blank 标签
                when (copySpanStyle) {
                    COPY_SPAN_DELETE -> {
                        //此方法为修改非正常类似BlankDataSpan中样式的span 为一个完整的BlankDataSpan
                        deleteCopySpan(text, showSpan)//此方法为删除多余的 非正常类似BlankDataSpan中样式的span

                    }
                    COPY_SPAN_SHOW_STYLE -> {
                        //转换成 空
                        showSpan = rectifyAsBlankDataSpan(text, showSpan)
                    }
                    else -> {
                    }
                }
                rectifyShowBlankSpanText(showSpan, text)
            }
        }
        isChangingSpan = false
    }

    /**
     * 将符合blank 标签的内容转换为 BlankDataSpan，并且重写排序
     */
    private fun rectifyAsBlankDataSpan(text: SpannableStringBuilder, showSpan: List<OkayDataSpan>): List<OkayDataSpan> {
        //检测所有的 符合 BlankDataSpan 的 非正常span
        var newShowSpan = showSpan

        //匹配 相符合 的 复制信息，用于生成新的balk data span
        var newSpan = changeCopySpanToBlankDataSpan(text, newShowSpan)

        if (newShowSpan.size < newSpan.size) {
            newShowSpan = newSpan.sortedBy {
                text.getSpanStart(it)
            }
        }
        rectifyShowBlankSpanText(newShowSpan, text)

        return newShowSpan
    }

    /**
     * 纠正 blank 标签对应的内容展示
     */
    private fun rectifyShowBlankSpanText(showSpan: List<OkayDataSpan>, text: SpannableStringBuilder) {
        var index = 0
        showSpan.forEach {
            if (it is BlankDataSpan) {
                index++
                it.blank.index = index
                it.blank.changeContent()
                val spanStart = text.getSpanStart(it)
                val spanEnd = text.getSpanEnd(it)
                if (spanStart >= 0 && spanStart < text.length)
                    text.replace(spanStart, spanEnd, it.blank.content)
            }
        }
    }

    private fun sortBlankSsortBlankSpanListpanList(oldSpan: Array<OkayDataSpan>, content: String, text: Editable): List<OkayDataSpan> {
        return oldSpan.filter { contains(content, it, text) }.sortedBy {
            text.getSpanStart(it)
        }
    }

    /**
     * 删除 多余的不展示的blank 标签
     */
    private fun deleteUnnecessaryBlankSpan(delete: List<OkayDataSpan>, text: Editable) {
        delete.forEach {
            text.removeSpan(it)
            it.getSpanStyle().forEach { style ->
                text.removeSpan(style)
            }
        }
    }

    private fun changeCopySpanToBlankDataSpan(text: Editable, spanList: List<OkayDataSpan>): List<OkayDataSpan> {
        var newSpan: MutableList<OkayDataSpan> = ArrayList()
        if (spanList != null) {
            newSpan.addAll(spanList)
            (spanList.firstOrNull() as BlankDataSpan).run {
                text.getSpans(0, text.length, ForegroundColorSpan::class.java)?.filterNot {
                    (it.foregroundColor == this.color) && contains(spanList, text.getSpanStart(it), text)
                }?.run {
                    text.getSpans(0, text.length, UnderlineSpan::class.java)?.filterNot {
                        contains(spanList, text.getSpanStart(it), text)
                    }?.forEach {
                        var color = contains(text.getSpanStart(it), text.getSpanEnd(it), text, this)
                        if (color != null) {
                            var start = text.getSpanStart(it)
                            var end = text.getSpanEnd(it)
                            text.removeSpan(it)
                            text.removeSpan(color)
                            //添加
                            var blankDataSpan = (BlankDataSpan(Blank(spanList.size, "空")))
                            (text as SpannableStringBuilder).replace(start, end, newSpannable(blankDataSpan))

                            newSpan.add(blankDataSpan)
                        }
                    }
                }
            }
        }
        return newSpan
    }

    private fun filterSameSpanStartTextStyle(text: Editable, dataStyle: CharacterStyle, styles: ArrayList<CharacterStyle>, spanList: List<OkayDataSpan>) {
        var newSpan: MutableList<CharacterStyle>

        if (dataStyle is OkayTextStyleSpan) {
            if (styles.isEmpty()) {
                text.getSpans(0, text.length, dataStyle::class.java)?.filterNot {
                    (dataStyle.isSameTextStyle(it)) && contains(spanList, text.getSpanStart(it), text)
                }
            } else {
                text.getSpans(0, text.length, dataStyle::class.java).filterNot {
                    (dataStyle.isSameTextStyle(it)) && contains(spanList, text.getSpanStart(it), text)
                }
            }

        }
    }


    /**
     * 删除 copy 的span ，将其修改为普通样式文本
     */
    private fun deleteCopySpan(text: SpannableStringBuilder, newSpan: List<OkayDataSpan>): List<OkayDataSpan> {
        newSpan.firstOrNull()?.run {
            this.getSpanStyle().forEach { dataSpan ->
                if (dataSpan is OkayTextStyleSpan) {
                    text.getSpans(0, text.length, dataSpan::class.java)?.filter {
                        dataSpan.isSameTextStyle(it) && (contains(newSpan, text.getSpanStart(it), text))
                    }?.forEach { text.removeSpan(it) }
                }
            }

        }

        return newSpan
    }


    private fun contains(content: String, it: OkayDataSpan, text: Editable): Boolean {
        return content.subSequence(text.getSpanStart(it), text.getSpanEnd(it)) == it.getShowContent()
    }

    private fun contains(content: List<OkayDataSpan>, index: Int, text: Editable): Boolean {
        return (content.firstOrNull {
            index in text.getSpanStart(it) until text.getSpanEnd(it)
        }) != null
    }

    private fun contains(start: Int, end: Int, text: Editable, content: List<CharacterStyle>): CharacterStyle? {
        return content.firstOrNull {
            start == text.getSpanStart(it) && end == text.getSpanEnd(it)
        }
    }

    private fun newSpannable(blankDataSpan: BlankDataSpan): Spannable {
        return SpanFactory.newSpannable(blankDataSpan.getSpannedName(), blankDataSpan)
    }
}