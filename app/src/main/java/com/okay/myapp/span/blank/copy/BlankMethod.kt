package he.test.okay.com.testhe.span.blank.copy

import android.text.Spannable
import android.view.KeyEvent
import android.widget.EditText
import he.test.okay.com.testhe.span.blank.watcher.KeyCodeDeleteHelper
import he.test.okay.com.testhe.span.blank.watcher.NoCopySpanEditableFactory
import he.test.okay.com.testhe.span.blank.watcher.SelectionSpanWatcher
import he.test.okay.com.testhe.span.blank.watcher.SpanFactory
import he.test.okay.com.testhe.span.i.Method

/**
 * @author hesongchao
 * Created on 2019/6/18 14:53
 */
object BlankMethod: Method {
    override fun init(editText: EditText) {
        editText.text = null
        editText.setEditableFactory(NoCopySpanEditableFactory(
                SelectionSpanWatcher(BlankData::class)))
        editText.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                return@setOnKeyListener KeyCodeDeleteHelper.onDelDown(
                        (v as EditText).text)
            }
            return@setOnKeyListener false
        }
    }

    override fun newSpannable(user: BlankData): Spannable {
        return SpanFactory.newSpannable(user.getSpannedName(), user)
    }

}