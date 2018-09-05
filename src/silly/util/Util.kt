package silly.util

import org.apache.commons.beanutils.BeanUtils
import sun.misc.BASE64Encoder
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern
import javax.servlet.http.HttpServletRequest
import java.security.NoSuchAlgorithmException
import java.security.MessageDigest
import kotlin.experimental.and


/**
 * 获取UUID
 */
fun getUUID(): String {
    return java.util.UUID.randomUUID().toString().replace("-", "")
}

/**
 * 获取当前时间yyyy-mm--dd
 */
fun getCurrentDate(): String {
    return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
}

/**
 * 是否是电话号码
 */
fun isPhone(phone: String): Boolean {
    val pattern = "^134[0-8]\\d{7}\$|^13[^4]\\d{8}\$|^14[5-9]\\d{8}\$|^15[^4]\\d{8}\$|^16[6]\\d{8}\$|^17[0-8]\\d{8}\$|^18[\\d]{9}\$|^19[8,9]\\d{8}\$"
    return Pattern.matches(pattern, phone)
}

/**
 * 是否是邮箱
 */
fun isEmail(email: String): Boolean {
    val pattern = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
    return Pattern.matches(pattern, email)
}

/**
 * 将request对象转换成T对象
 */
fun <T> request2Bean(request: HttpServletRequest, clazz: Class<T>): T {
    try {
        val bean = clazz.newInstance()
        val e = request.parameterNames
        while (e.hasMoreElements()) {
            val name = e.nextElement() as String
            val value = request.getParameter(name)
            BeanUtils.setProperty(bean, name, value)
        }
        return bean
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}

/**
 * 生成32位md5码
 */
fun encodeMD5(str: String): String {
    try {
        val instance: MessageDigest = MessageDigest.getInstance("MD5")//获取md5加密对象
        val digest: ByteArray = instance.digest(str.toByteArray())//对字符串加密，返回字节数组
        val sb = StringBuffer()
        for (b in digest) {
            val i: Int = b.toInt() and 0xff//获取低八位有效值
            var hexString = Integer.toHexString(i)//将整数转化为16进制
            if (hexString.length < 2) {
                hexString = "0$hexString"//如果是一位的话，补0
            }
            sb.append(hexString)
        }
        return sb.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}

/**
 * 逐位随机取值，转成字符串，然后再拼接成6位的字符串
 *
 * @return 6位字符串
 */
fun getRandNumber(): String {
    val numStr = StringBuffer()
    var num: Int
    for (i in 0..5) {
        // Math.random() 随机出0-1之间的实数，返回值是一个double 类型的
        num = (Math.random() * 10).toInt()
        numStr.append(num.toString())
    }
    return numStr.toString()
}


/**
 * 生成Token
 * Token：Nv6RRuGEVvmGjB+jimI/gw==
 *
 * @return
 */
fun makeToken(): String {  //checkException
    //  7346734837483  834u938493493849384  43434384
    val token = (System.currentTimeMillis() + Random().nextInt(999999999)).toString() + ""
    //数据指纹   128位长   16个字节  md5
    try {
        val md = MessageDigest.getInstance("md5")
        val md5 = md.digest(token.toByteArray())
        //base64编码--任意二进制编码明文字符   adfsdfsdfsf
        val encoder = BASE64Encoder()
        return encoder.encode(md5)
    } catch (e: NoSuchAlgorithmException) {
        throw RuntimeException(e)
    }

}
