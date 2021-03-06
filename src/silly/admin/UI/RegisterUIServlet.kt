package silly.admin.UI

import silly.util.makeToken
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

/**
 * LoginUIServlet负责为用户输出登陆界面
 * 当用户访问LoginUIServlet时，就跳转到目录下的login.jsp页面
 */
@WebServlet(name = "RegisterUIServlet", urlPatterns = ["/register_ui"])
class RegisterUIServlet : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        request.getRequestDispatcher("/admin/register.jsp").forward(request, response)
    }

    @Throws(ServletException::class, IOException::class)
    public override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        doGet(request, response)
    }

}
