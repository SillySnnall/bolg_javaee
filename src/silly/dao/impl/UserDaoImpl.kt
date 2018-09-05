package silly.dao.impl

import org.apache.commons.dbutils.handlers.BeanHandler
import silly.base.BaseDao
import silly.bean.User
import silly.dao.IUserDao

import java.sql.SQLException

/**
 * 用户dao
 */
class UserDaoImpl : BaseDao(), IUserDao {
    override fun find(user_name: String, password: String): User? {
        try {
            val sql = "select * from user where user_name='$user_name' AND password='$password'"
            return getQueryRunner().query(sql, BeanHandler<User>(User::class.java))
        } catch (e: SQLException) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }

    override fun find(user_name: String): User? {
        try {
            val sql = "select * from user where user_name='$user_name'"
            return getQueryRunner().query(sql, BeanHandler<User>(User::class.java))
        } catch (e: SQLException) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }

    override fun add(user: User) {
        try {
            val sql = "insert into user(uid,user_name,password,create_time) values('${user.uid}','${user.user_name}','${user.password}','${user.create_time}')"
            getQueryRunner().update(sql)
        } catch (e: SQLException) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }
}
