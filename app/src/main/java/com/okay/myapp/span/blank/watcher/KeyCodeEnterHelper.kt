package he.test.okay.com.testhe.span.blank.watcher

import android.text.Selection
import android.text.Spannable
import he.test.okay.com.testhe.span.blank.self.OkayEnterSymbolSpan

/**
 * @author hesongchao
 * Created on 2019/6/25 11:17
 */
class KeyCodeEnterHelper private constructor() {
    companion object {
        fun onEnterDown(text: Spannable): Boolean {
            val selectionStart = Selection.getSelectionStart(text)
            val selectionEnd = Selection.getSelectionEnd(text)
            text.setSpan(OkayEnterSymbolSpan(), selectionStart, selectionEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            return false
        }
    }
}