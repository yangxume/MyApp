package he.test.okay.com.testhe.span.blank.self.watcher

import android.text.Selection
import android.text.SpanWatcher
import android.text.Spannable
import android.util.Log
import android.widget.EditText
import kotlin.reflect.KClass

/**
 * @author hesongchao
 * Created on 2019/6/21 11:48
 * 处理span 发生变化
 */
class OkayBlankSelectionWatcher<T : Any>(private val kClass: KClass<T>) : SpanWatcher {

    private var selStart = 0
    private var selEnd = 0

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
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSpanAdded(text: Spannable?, what: Any?, start: Int, end: Int) {
        //To change body of created functions use File | Settings | File Templates.
    }

}