package he.test.okay.com.testhe.span.blank.self

import android.text.style.CharacterStyle
import android.text.style.UnderlineSpan
import he.test.okay.com.testhe.span.blank.data.OkayTextStyleSpan

/**
 * @author hesongchao
 * Created on 2019/6/20 19:16
 */
class OkayUnderlineSpan : UnderlineSpan(), OkayTextStyleSpan {
    override fun isSameTextStyle(style: CharacterStyle): Boolean {
        return style is UnderlineSpan
    }
}