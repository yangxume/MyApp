package he.test.okay.com.testhe.span.i

/**
 * @author hesongchao
 * Created on 2019/6/18 09:51
 */
interface DataBindingSpan<T> {
    fun spannedText(): CharSequence
    fun bindingData(): T
}