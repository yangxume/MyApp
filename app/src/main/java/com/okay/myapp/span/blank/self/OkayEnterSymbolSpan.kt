package he.test.okay.com.testhe.span.blank.self

import he.test.okay.com.testhe.span.blank.data.OkaySymbolSpan

/**
 * @author hesongchao
 * Created on 2019/6/25 11:29
 */
class OkayEnterSymbolSpan : OkaySymbolSpan {


    override fun getSymbolStyle(): Int {
        return OkaySymbolSpan.STYLE_ENTER
    }

    override fun length(): Int {
        return 0
    }

    override fun getTag(): String {
        return "enter"
    }

}