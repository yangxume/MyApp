package he.test.okay.com.testhe.span.blank.data

import android.text.Spannable
import android.text.style.CharacterStyle

/**
 * @author hesongchao
 * Created on 2019/6/24 15:41
 */
interface OkayDataSpan : OkayCharSpan {

    /**
     * 获取用于显示的内容
     */
    fun getShowContent(): String

    /**
     * 获取显示内容的 Spannable
     */
    fun getSpannedName(): Spannable

    /**
     * 获取显示内容的Style
     * @see CharacterStyle
     *  此样式还实现  OkayTextStyleSpan  便于分辨处理
     * 必须是CharacterStyle的子类
     */
    fun getSpanStyle(): List<CharacterStyle>
}