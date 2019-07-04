package he.test.okay.com.testhe.span.blank.self

import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import he.test.okay.com.testhe.span.blank.data.OkayTextStyleSpan

/**
 * @author hesongchao
 * Created on 2019/6/20 19:14
 */
class OkayForegroundColorSpan(color: Int) : ForegroundColorSpan(color), OkayTextStyleSpan {
    override fun isSameTextStyle(style: CharacterStyle): Boolean {
        return (style is ForegroundColorSpan && style.foregroundColor == this.foregroundColor)
    }
}