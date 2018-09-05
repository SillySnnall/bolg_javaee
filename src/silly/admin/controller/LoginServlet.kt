package silly.admin.controller


import silly.service.impl.UserServiceImpl
import silly.admin.formbean.LoginFormBean

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

import silly.util.request2Bean

/**
 * 处理用户登录的servlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = ["/login"])
class LoginServlet : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        // 提交的数据转换为bean
        val formbean = request2Bean(request, LoginFormBean::class.java)
        // 提交字段判断
        if(!formbean.validate()){
            // 设置bean，jsp调用
            request.setAttribute("formbean", formbean)
            // 请求转发到login.jsp
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response)
            return
        }

        val service = UserServiceImpl()
        //用户登录
        val user = service.loginUser(formbean.user_name, formbean.password)
        if (user == null) {
            formbean.errors = "手机号或密码错误"
            // 设置bean，jsp调用
            request.setAttribute("formbean", formbean)
            // 请求转发到login.jsp
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response)
            return
        }
        //登录成功后，就将用户存储到session中
        request.session.setAttribute("user", user)
        // 重定向到bolg_list.jsp
        response.sendRedirect("/admin/bolg_list.jsp")
    }

    @Throws(ServletException::class, IOException::class)
    public override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        doGet(request, response)
    }

}
