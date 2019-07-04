package he.test.okay.com.testhe.span.blank

import android.app.Activity
import android.text.*
import android.text.method.ScrollingMovementMethod
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.okay.myapp.R
import he.test.okay.com.testhe.R
import he.test.okay.com.testhe.base.BaseViewGroup
import he.test.okay.com.testhe.span.blank.data.OkayCharSpan
import he.test.okay.com.testhe.span.blank.self.Blank
import he.test.okay.com.testhe.span.blank.self.BlankDataSpan
import he.test.okay.com.testhe.span.blank.self.watcher.OkayBlankSelectionWatcher
import he.test.okay.com.testhe.span.blank.self.watcher.OkayBlankTextWatcher
import he.test.okay.com.testhe.span.blank.watcher.*

/**
 * @author hesongchao
 * Created on 2019/6/18 16:20
 */
/**
 * @author hesongchao
 * Created on 2019/6/18 10:39
 */

class EditTextSpanView(context: Activity) : BaseViewGroup(context) {

    lateinit var rootView: LinearLayout

    lateinit var editText: EditText

    lateinit var tv: TextView

    override fun initDate() {
    }

    override fun initView() {
        rootView = context.layoutInflater.inflate(R.layout.layout_edittext, null).apply {
            editText = findViewById(R.id.et_text) as EditText
            findViewById(R.id.btn_append).setOnClickListener { view -> appendString(view) }
            findViewById(R.id.btn_print).setOnClickListener { view -> printString(view) }
            tv = rootView.findViewById(R.id.tv_content) as TextView
        } as LinearLayout
        iniViewClick()
    }

    private fun iniViewClick() {

        with(editText) {
            //            var blankSelectionSpanWatcher = BlankSelectionSpanWatcher(editText,
//                    BlankSpan::class)
            setEditableFactory(NoCopySpanEditableFactory(OkayBlankSelectionWatcher(
                    BlankDataSpan::class)))

            setOnKeyListener { v, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                    return@setOnKeyListener KeyCodeDeleteHelper.onDelDown(
                            (v as EditText).text)
                } else if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                    return@setOnKeyListener KeyCodeEnterHelper.onEnterDown(
                            (v as EditText).text)
                }
                return@setOnKeyListener false
            }
            addTextChangedListener(OkayBlankTextWatcher(this, OkayBlankTextWatcher.COPY_SPAN_SHOW_STYLE))
//            addTextChangedListener(blankSelectionSpanWatcher)
        }
    }

    var index = 0
    private fun appendString(view: View) {
        index++
        var text = editText!!.text
        var selectionStart = Selection.getSelectionStart(text)
        // var newSpan = newSpannable(BlankDataSpan(Blank(index, "空")))
        (text as SpannableStringBuilder).insert(selectionStart, newSpannable(BlankDataSpan(Blank(index, "空"))))
        //.insert(selectionStart + newSpan.length, " ")

    }

    fun printString(view: View) {
        val editable = editText.text
        var textContent = editable.toString()
        var start = 0

        var newSpan = editable.getSpans(0, editText.length(), OkayCharSpan::class.java).sortedBy {
            editable.getSpanStart(it)
        }
        tv.text = newSpan.joinToString("\n") {
            var spanStart = editable.getSpanStart(it)
            var spanEnd = editable.getSpanEnd(it)
            var input = ""
            if (start < spanStart) {
                input = " <Text> ${textContent.subSequence(start, spanStart)} </Text>\n"
            }
            start = editable.getSpanEnd(it)

            if (it is BlankDataSpan) {
                // "$input ${it.blank}, start $spanStart,end $spanEnd"
                "$input <${it.getTag()}> ${it.blank},  spanStart:$spanStart, spanEnd:$spanEnd </${it.getTag()}>"
            } else {
                "$input <${it.getTag()}> $it, spanStart:$spanStart, spanEnd:$spanEnd </${it.getTag()}>"
            }
        }
        if (start < textContent.length - 1)
            tv.append("\n <Text> ${textContent.subSequence(start, textContent.length - 1)} </Text>\n")

        tv.scrollTo(0, 0)

        tv.movementMethod = ScrollingMovementMethod.getInstance()
    }

    private fun newSpannable(user: BlankDataSpan): Spannable {
        return SpanFactory.newSpannable(user.getSpannedName(), user)
    }
}