package silly.admin.controller


import org.apache.commons.beanutils.BeanUtils
import silly.admin.formbean.RegisterFormBean
import silly.bean.User
import silly.exception.ExistException
import silly.service.impl.UserServiceImpl
import silly.util.encodeMD5

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

import silly.util.getUUID
import silly.util.request2Bean

/**
 * 处理用户注册的Servlet
 * @author gacl
 */
@WebServlet(name = "RegisterServlet", urlPatterns = ["/register"])
class RegisterServlet : HttpServlet() {
    @Throws(ServletException::class, IOException::class)
    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        //将客户端提交的表单数据封装到RegisterFormBean对象中
        val formbean = request2Bean(request, RegisterFormBean::class.java)
        //校验用户注册填写的表单数据
        if (!formbean.validate()) {//如果校验失败
            errorShow(formbean, request, response)
            return
        }
        val service = UserServiceImpl()
        try {// 判断是发送验证码，还是注册
            if (formbean.type.equals("获取")) {
                if (request.session.getAttribute("code") == null) {
                    errorShow("验证码已发送", formbean, request, response)
                    return
                }
                val sendCode = service.sendCode(formbean.user_name)
                // 验证码发送成，将验证码存到session
                request.session.setAttribute("code", sendCode)
                errorShow("验证码发送成功", formbean, request, response)
                return
            }
        } catch (message: ExistException) {
            errorShow(message.toString(), formbean, request, response)
            return
        } catch (e: Exception) {
            errorShow("验证码发送失败", formbean, request, response)
            return
        }

        try {
            // 判断验证码是否正确
            val attributeCode = request.session.getAttribute("code")
            if (attributeCode == null || !attributeCode.equals(formbean.code)) {
                errorShow("验证码不正确", formbean, request, response)
                return
            }
            val user = User()
            BeanUtils.copyProperties(user, formbean)//把表单的数据填充到javabean中
            user.uid = getUUID()//设置用户的Id属性
            //调用service层提供的注册用户服务实现用户注册
            service.registerUser(user)
            //注册成功后，就将用户存储到session中
            request.session.setAttribute("user", user)
            // 重定向到bolg_list.jsp
            response.sendRedirect("/admin/bolg_list.jsp")

        } catch (message: ExistException) {
            errorShow(message.message.toString(), formbean, request, response)
        } catch (e: Exception) {
            errorShow("注册失败", formbean, request, response)
        }
    }

    private fun errorShow(errors: String, formbean: RegisterFormBean, request: HttpServletRequest, response: HttpServletResponse) {
        if (errors.isNotEmpty()) formbean.errors = errors
        //将封装了用户填写的表单数据的formbean对象发送回register.jsp页面的form表单中进行显示
        request.setAttribute("formbean", formbean)
        //校验失败就说明是用户填写的表单数据有问题，那么就跳转回register.jsp
        request.getRequestDispatcher("/admin/register.jsp").forward(request, response)
    }

    private fun errorShow(formbean: RegisterFormBean, request: HttpServletRequest, response: HttpServletResponse) {
        errorShow("", formbean, request, response)
    }

    @Throws(ServletException::class, IOException::class)
    public override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        doGet(request, response)
    }
}