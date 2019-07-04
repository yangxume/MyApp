package he.test.okay.com.testhe.span.blank.data

/**
 * @author hesongchao
 * Created on 2019/6/25 11:24
 */
interface OkaySymbolSpan : OkayCharSpan {

    companion object {
        const val STYLE_ENTER = 1//换行符
    }

    fun getSymbolStyle(): Int
}