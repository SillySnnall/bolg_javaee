package silly.admin.filter.wrapper

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper

class CharacterEncodingRequest(private val request: HttpServletRequest) : HttpServletRequestWrapper(request) {
    override fun getParameter(name: String?): String? {
        try {
            //获取参数的值
            return this.request.getParameter(name)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}