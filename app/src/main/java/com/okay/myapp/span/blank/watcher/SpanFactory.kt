package he.test.okay.com.testhe.span.blank.watcher

import android.text.Spannable
import android.text.SpannableString
import he.test.okay.com.testhe.span.blank.self.BlankDataSpan

/**
 * @author hesongchao
 * Created on 2019/6/18 11:45
 */
object SpanFactory {
    fun newSpannable(source: CharSequence, vararg spans: Any): Spannable {
        return SpannableString.valueOf(source).apply {
            spans.forEach {
                setSpan(it, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }
}
