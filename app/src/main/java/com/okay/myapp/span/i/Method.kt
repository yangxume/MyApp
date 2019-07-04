package he.test.okay.com.testhe.span.i

import android.text.Spannable
import android.widget.EditText
import he.test.okay.com.testhe.span.blank.copy.BlankData


interface Method {

    fun init(editText: EditText)
    fun newSpannable(user: BlankData): Spannable

}