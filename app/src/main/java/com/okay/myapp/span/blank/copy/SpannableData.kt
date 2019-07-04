package he.test.okay.com.testhe.span.blank.copy

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import he.test.okay.com.testhe.span.i.DataBindingSpan

/**
 * @author hesongchao
 * Created on 2019/6/18 09:52
 */
class SpannableData(private val spanned: String) : DataBindingSpan<String> {

    override fun spannedText(): CharSequence {
      return SpannableString(spanned).apply {
            setSpan(ForegroundColorSpan(Color.RED), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    override fun bindingData(): String {
        return spanned
    }


}