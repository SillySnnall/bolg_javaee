package silly.dao

import silly.bean.User
import silly.exception.ExistException

interface IUserDao {
    /**
     * 根据用户名和密码来查找用户
     */
    fun find(user_name: String, password: String):User?

    /**
     * 根据用户名来查找用户
     */
    fun find(userName: String): User?

    /**
     * 添加用户
     */
    fun add(user: User)
}
