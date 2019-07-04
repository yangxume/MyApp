package he.test.okay.com.testhe.span.blank.watcher

/**
 * @author hesongchao
 * Created on 2019/6/18 10:36
 */
import android.text.Selection
import android.text.Spannable
import he.test.okay.com.testhe.span.blank.data.BlankDataSpan

class KeyCodeDeleteHelper private constructor(){
    companion object {
        fun onDelDown(text: Spannable): Boolean {
            val selectionStart = Selection.getSelectionStart(text)
            val selectionEnd = Selection.getSelectionEnd(text)
            text.getSpans(selectionStart, selectionEnd, BlankDataSpan::class.java).firstOrNull { text.getSpanEnd(it) == selectionStart }?.run {
                return (selectionStart == selectionEnd).also {
                    val spanStart = text.getSpanStart(this)
                    val spanEnd = text.getSpanEnd(this)
                    Selection.setSelection(text, spanStart, spanEnd)
                }
            }
            return false
        }
    }
}