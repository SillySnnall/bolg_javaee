package silly.admin.controller

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException
import java.text.MessageFormat

@WebServlet(name = "LogoutServlet", urlPatterns = ["/logout"])
class LogoutServlet : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        //移除存储在session中的user对象，实现注销功能
        request.session.removeAttribute("user")

        // 重定向到bolg_list.jsp
        response.sendRedirect("/admin/bolg_list.jsp")
    }

    @Throws(ServletException::class, IOException::class)
    public override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        doGet(request, response)
    }

}
