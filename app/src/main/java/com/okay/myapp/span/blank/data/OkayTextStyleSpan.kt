package he.test.okay.com.testhe.span.blank.data

import android.text.style.CharacterStyle

/**
 * @author hesongchao
 * Created on 2019/6/20 19:14
 */
interface OkayTextStyleSpan : OkayCharStyleSpan {

    fun isSameTextStyle(style: CharacterStyle): Boolean


}