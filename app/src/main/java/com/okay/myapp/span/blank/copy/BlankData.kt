package he.test.okay.com.testhe.span.blank.copy

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import he.test.okay.com.testhe.span.blank.data.BlankDataSpan

/**
 * @author hesongchao
 * Created on 2019/6/18 11:38
 */
data class BlankData(val index: Int, var content: String) {

    fun getSpannedName(): Spannable {
        return SpannableString("$content").apply {
            setSpan(ForegroundColorSpan(Color.RED), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(UnderlineSpan(), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    fun isDirty(text: Spannable): Boolean {
        val spanStart = text.getSpanStart(this)
        val spanEnd = text.getSpanEnd(this)
        return spanStart >= 0 && spanEnd >= 0 && text.substring(spanStart, spanEnd) != "$content"
    }

}