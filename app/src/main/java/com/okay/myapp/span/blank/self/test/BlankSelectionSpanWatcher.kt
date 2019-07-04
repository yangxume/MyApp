package he.test.okay.com.testhe.span.blank.self.test

import android.os.Handler
import android.text.*
import android.text.style.CharacterStyle
import android.widget.EditText
import he.test.okay.com.testhe.span.blank.self.BlankDataSpan
import kotlin.reflect.KClass


/**
 * @author hesongchao
 * Created on 2019/6/19 18:56
 */
class BlankSelectionSpanWatcher<T : Any>(private var editText: EditText, private val kClass: KClass<T>) : SpanWatcher {

    private var selStart = 0
    private var selEnd = 0
    var isChanging = false

    override fun onSpanChanged(text: Spannable, what: Any, ostart: Int, oend: Int, nstart: Int, nend: Int) {
        if (what === Selection.SELECTION_END && selEnd != nstart) {
            selEnd = nstart
            text.getSpans(nstart, nend, kClass.java).firstOrNull()?.run {
                val spanStart = text.getSpanStart(this)
                val spanEnd = text.getSpanEnd(this)
                val index = if (Math.abs(selEnd - spanEnd) > Math.abs(selEnd - spanStart)) spanStart else spanEnd
                Selection.setSelection(text, Selection.getSelectionStart(text), index)
            }
        }
        if (what === Selection.SELECTION_START && selStart != nstart) {
            selStart = nstart
            text.getSpans(nstart, nend, kClass.java).firstOrNull()?.run {
                val spanStart = text.getSpanStart(this)
                val spanEnd = text.getSpanEnd(this)
                val index = if (Math.abs(selStart - spanEnd) > Math.abs(selStart - spanStart)) spanStart else spanEnd
                Selection.setSelection(text, index, Selection.getSelectionEnd(text))
            }
        }
    }


    override fun onSpanRemoved(text: Spannable?, what: Any?, start: Int, end: Int) {
//        if (what is CharacterStyle || what is BlankDataSpan) {
//            editText.text.removeSpan(what)
//            text?.removeSpan(what)
//            onSpanChange(text, what, start, end, false)
//        }
    }
    var handler: Handler = Handler()
    override fun onSpanAdded(text: Spannable?, what: Any?, start: Int, end: Int) {
        //onSpanChange(text, what, start, end, true)
    }


    private fun onSpanChange(text: Spannable?, what: Any?, start: Int, end: Int, isAdd: Boolean) {
        if (isChanging) return
        if (text != null && what is BlankDataSpan) {
            isChanging = true
            handler.postDelayed({
                onSpanChange(text)
            }, 100L)

        }
    }

    private fun onSpanChange(text: Spannable) {
        var index = 0
        var oldSpan = text.getSpans(0, text.length, kClass.java)
        var newSpan = oldSpan.sortedBy {
            text.getSpanStart(it)
        }
        newSpan.forEach {
            if (it is BlankDataSpan) {
                index++
                it.blank.index = index
                it.blank.changeContent()
                val spanStart = text.getSpanStart(it)
                val spanEnd = text.getSpanEnd(it)
                if (spanStart >= 0 && spanStart < editText!!.text.length)
                    editText.text.replace(spanStart, spanEnd, it.blank.content)

            }
        }
        isChanging = false
    }


    private fun replace(s: CharSequence?, before: Int, count: Int): Boolean {
        if (isChanging) return true
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
        return false
    }

    private fun deleteSpan(text: Editable) {
        var selectionStart = Selection.getSelectionStart(text)
        var selectionEnd = Selection.getSelectionEnd(text)
        //var styles=   text.getSpans(selectionStart, selectionStart, CharacterStyle::class.java)
        var blankData = text.getSpans(selectionStart, selectionEnd, CharacterStyle::class.java)
//        styles.forEach {
//            text.removeSpan(it)
//        }

        blankData.forEach {
            text.removeSpan(it)
        }


    }
}
