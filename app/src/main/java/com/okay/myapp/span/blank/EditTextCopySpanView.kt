package he.test.okay.com.testhe.span.blank

import android.app.Activity
import android.text.SpannableStringBuilder
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import he.test.okay.com.testhe.R
import he.test.okay.com.testhe.base.BaseViewGroup
import he.test.okay.com.testhe.span.blank.copy.BlankData
import he.test.okay.com.testhe.span.blank.copy.BlankMethod
import he.test.okay.com.testhe.span.blank.copy.MethodContext
import he.test.okay.com.testhe.span.blank.data.BlankDataSpan

/**
 * @author hesongchao
 * Created on 2019/6/18 10:39
 */

class EditTextCopySpanView(context: Activity) : BaseViewGroup(context) {

    lateinit var rootView: LinearLayout

    lateinit    var  editText: EditText

    lateinit var tv: TextView
    lateinit  var blankMethod: MethodContext
    override fun initDate() {
    }

    override fun initView() {
        rootView = context.layoutInflater.inflate(R.layout.layout_edittext, null) as LinearLayout
        editText = rootView.findViewById(R.id.et_text) as EditText


        rootView.findViewById(R.id.btn_append).setOnClickListener { view -> appendString(view) }
        rootView.findViewById(R.id.btn_print).setOnClickListener { view -> printString(view) }
        initMethod()
        tv = rootView!!.findViewById(R.id.tv_content) as TextView
    }

    private fun initMethod() {
        blankMethod = MethodContext()
        blankMethod.method = BlankMethod
        blankMethod.init(editText!!)
    }

    var index = 0
    fun appendString(view: View) {
        index++
        //var spannableData = SpannableData("第" + index + "空")
        var blankData = BlankData(index, " 空$index ")
        (editText!!.text as SpannableStringBuilder)
                .append(blankMethod!!.newSpannable(blankData))
                .append(" ")

    }

    fun printString(view:View){
            val editable = editText.text
        tv.text = editable.getSpans(0, editText.length(), BlankDataSpan::class.java).joinToString("\n") {
                "$it, ${editable.getSpanStart(it)}, ${editable.getSpanEnd(it)}"
            }
            tv.scrollTo(0, 0)

        tv.movementMethod = ScrollingMovementMethod.getInstance()
    }

}