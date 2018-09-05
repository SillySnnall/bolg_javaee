package silly.test

import silly.bean.User
import silly.dao.impl.UserDaoImpl
import silly.util.*
import sun.security.provider.MD5

/**
 * 测试
 */
object TestCommon {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {

//        UserDaoImpl().add(User(getUUID(), "15559733554", encodeMD5("411600050"), getCurrentDate()))
//        val find = UserDaoImpl().find("15559733554")
//        println(find.toString())


//        val md5Password = encodeMD5("胜利大街阿d道夫拉近了倒计时")
//        println(md5Password)
//        val code = SmsUtil.sendCode("15559733554")
//        println(code)

        val xxx = null

        val s = xxx as String
        println(s)
    }
}
