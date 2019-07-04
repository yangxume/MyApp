package he.test.okay.com.testhe.span.blank.self

/**
 * @author hesongchao
 * Created on 2019/6/18 16:26
 */
data class Blank(var index: Int, private var name: String) {
    var content: String = " " + (if (name.isNullOrEmpty()) index.toString() else (name + index)) + " "
    //var content = "   "

    override fun toString(): String {
        return " index:$index, content:$content "
    }

    fun changeContent() {
        content = " " + (if (name.isNullOrEmpty()) index.toString() else (name + index)) + " "
        //content = "  "
    }
}
