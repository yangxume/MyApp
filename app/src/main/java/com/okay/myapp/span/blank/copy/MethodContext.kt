package he.test.okay.com.testhe.span.blank.copy

import android.text.Spannable
import android.widget.EditText
import he.test.okay.com.testhe.span.i.Method

class MethodContext: Method {
     var method: Method? = null
    override fun init(editText: EditText) {
        method?.init(editText)
    }

    override fun newSpannable(user: BlankData): Spannable {
        return method?.newSpannable(user) ?: throw NullPointerException("method: null")
    }

}