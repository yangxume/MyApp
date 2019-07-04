package he.test.okay.com.testhe.span.blank.self

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.CharacterStyle
import he.test.okay.com.testhe.span.blank.data.BlankDataSpan
import he.test.okay.com.testhe.span.blank.data.OkayTextStyleSpan

/**
 * @author hesongchao
 * Created on 2019/6/18 16:37
 */

class BlankDataSpan(val blank: Blank) : BlankDataSpan {
    override fun getTag(): String {
        return "blank"
    }

    override fun length(): Int {
        return blank.content.length
    }

    var listStyle = arrayListOf<CharacterStyle>()
    val color = Color.RED

    init {
        listStyle.add(OkayForegroundColorSpan(color))
        listStyle.add(OkayUnderlineSpan())
    }

    override fun getShowContent(): String {
        return blank.content
    }


    override fun getSpanStyle(): List<CharacterStyle> {
        return listStyle
    }

    var colorSpan: OkayForegroundColorSpan? = null
    var lineSpan: OkayUnderlineSpan? = null


    override fun getSpannedName(): Spannable {
        return SpannableString("${blank.content}").apply {
            listStyle.forEach {
                setSpan(it, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }

}