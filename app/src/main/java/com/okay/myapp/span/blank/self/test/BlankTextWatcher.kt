package he.test.okay.com.testhe.span.blank.self.test

import android.text.*
import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.EditText
import he.test.okay.com.testhe.span.blank.self.Blank
import he.test.okay.com.testhe.span.blank.self.BlankDataSpan
import he.test.okay.com.testhe.span.blank.watcher.SpanFactory
import he.test.okay.com.testhe.span.blank.data.OkayTextWatcher

/**
 * @author hesongchao
 * Created on 2019/6/19 11:29
 */
class BlankTextWatcher(private var editText: EditText) : TextWatcher, OkayTextWatcher {

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

    private var copySpanStyle = COPY_SPAN_SHOW_NONE


    private var isChanging = false

    override fun afterTextChanged(s: Editable?) {
        //To change body of created functions use File | Settings | File Templates.
        // text 变化后 校正不对应的span
        textChangeSpan()
    }

    private fun textChangeSpan() {
        if (isChanging) return
        isChanging = true
        var text = editText.text
        (text as SpannableStringBuilder).run {
            var content = text.toString()
            var index = 0

            var oldSpan = text.getSpans(0, text.length, BlankDataSpan::class.java)
            oldSpan?.run {
                var delete = oldSpan.filterNot {
                    it is BlankDataSpan && contains(content, it, text)
                }

                var showSpan = oldSpan.filter { it is BlankDataSpan && contains(content, it, text) }.sortedBy {
                    text.getSpanStart(it)
                }

                delete.forEach {
                    text.removeSpan(it)
                    if (it is BlankDataSpan) {
                        text.removeSpan(it.colorSpan)
                        text.removeSpan(it.lineSpan)
                    }

                }

                when (copySpanStyle) {
                   COPY_SPAN_DELETE -> {
                        //此方法为修改非正常类似BlankDataSpan中样式的span 为一个完整的BlankDataSpan
                        deleteCopySpan(text, showSpan)//此方法为删除多余的 非正常类似BlankDataSpan中样式的span
                    }
                  COPY_SPAN_SHOW_STYLE -> {
                        //检测所有的 符合 BlankDataSpan 的 非正常span
                        var newSpan = changeCopySpanToBlankDataSpan(text, showSpan)
                        if (showSpan.size < newSpan.size) {
                            showSpan = newSpan.sortedBy {
                                text.getSpanStart(it)
                            }
                        }
                    }
                   COPY_SPAN_SHOW_NONE -> {

                    }
                    else -> {

                    }

                }



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

        }
        isChanging = false
    }

    private fun changeCopySpanToBlankDataSpan(text: Editable, spanList: List<BlankDataSpan>): List<BlankDataSpan> {
        var newSpan: MutableList<BlankDataSpan> = ArrayList()
        if (spanList != null) {
            newSpan.addAll(spanList)

            text.getSpans(0, text.length, ForegroundColorSpan::class.java)?.filterNot {
                (it.foregroundColor == spanList.firstOrNull()?.color) && contains(spanList, text.getSpanStart(it), text)
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
        return newSpan
    }

    private fun deleteCopySpan(text: Editable, newSpan: List<BlankDataSpan>) {
        newSpan.isNotEmpty().run {
            text.getSpans(0, text.length, UnderlineSpan::class.java)?.filterNot {
                contains(newSpan, text.getSpanStart(it), text)
            }?.forEach { text.removeSpan(it) }

            text.getSpans(0, text.length, ForegroundColorSpan::class.java)?.filterNot {
                (it.foregroundColor == newSpan.firstOrNull()?.color) && contains(newSpan, text.getSpanStart(it), text)
            }?.forEach { text.removeSpan(it) }
        }
    }


    private fun contains(content: String, it: BlankDataSpan, text: Editable): Boolean {
        return content.subSequence(text.getSpanStart(it), text.getSpanEnd(it)) == it.blank.content
    }

    private fun contains(content: List<BlankDataSpan>, index: Int, text: Editable): Boolean {
        return (content.firstOrNull {
            index in text.getSpanStart(it) until text.getSpanEnd(it)
        }) != null
    }

    private fun contains(start: Int, end: Int, text: Editable, content: List<CharacterStyle>): CharacterStyle? {
        return content.firstOrNull {
            start == text.getSpanStart(it) && end == text.getSpanEnd(it)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //To change body of created functions use File | Settings | File Templates.

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //text 变化后 校正不对应的span
        //  replaceSpan(s, before, count)


    }


    private fun replaceSpan(s: CharSequence?, before: Int, count: Int) {
        s?.run {
            when {
                before == 0 -> {
                    //新增 count 为新增字符长度
                }
                count == 0 -> {
                    //删除  before 为删除的长度
                }
                before > 0 && count > 0 -> {
                    //替换
                    deleteSpan(editText.text)
                }
            }
        }
    }

    private fun deleteSpan(text: Editable) {
        var selectionStart = Selection.getSelectionStart(text)
        var selectionEnd = Selection.getSelectionEnd(text)

        var blankSpan = text.getSpans(selectionStart, selectionEnd, BlankDataSpan::class.java)

        text.getSpans(selectionStart, selectionEnd, CharacterStyle::class.java).forEach {
            var showBank = blankSpan.filter {
                selectionStart in text.getSpanStart(it)..(text.getSpanEnd(it) + 1)
            }
            if (showBank.isEmpty()) {
                text.removeSpan(it)
            }
        }
    }

    private fun newSpannable(user: BlankDataSpan): Spannable {
        return SpanFactory.newSpannable(user.getSpannedName(), user)
    }
}