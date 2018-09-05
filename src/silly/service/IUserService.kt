package silly.service


import silly.bean.User
import silly.exception.ExistException

interface IUserService {

    /**
     * 提供注册服务
     */
    @Throws(ExistException::class)
    fun registerUser(user: User)

    /**
     * 提供登录服务
     */
    fun loginUser(user_name: String, password: String): User?

    /**
     * 发送验证码
     */
    @Throws(ExistException::class)
    fun sendCode(user_name: String): String
}