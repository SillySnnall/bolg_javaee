package silly.service.impl

import silly.bean.User
import silly.dao.impl.UserDaoImpl
import silly.exception.ExistException
import silly.service.IUserService
import silly.util.SmsUtil
import silly.util.encodeMD5
import silly.util.getCurrentDate

/**
 * 用户服务
 */
class UserServiceImpl : IUserService {


    private val userDao = UserDaoImpl()

    /**
     * 注册
     */
    override fun registerUser(user: User) {
        if (userDao.find(user.user_name) != null) {
            throw ExistException("注册的用户名已存在")
        }
        // 密码MD5加密
        user.password = encodeMD5(user.password)
        user.create_time = getCurrentDate()
        userDao.add(user)
    }

    /**
     * 登录
     */
    override fun loginUser(user_name: String, password: String): User? {
        return userDao.find(user_name, encodeMD5(password))
    }

    /**
     * 发送验证码
     */
    override fun sendCode(user_name: String): String {
        val code = SmsUtil.sendCode(user_name)
        if (code.isEmpty()) {
            throw ExistException("验证码发送失败")
        }
        return code
    }

}