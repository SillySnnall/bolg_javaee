package silly.admin.filter;

import silly.admin.filter.wrapper.CharacterEncodingRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RootFilter", urlPatterns = "/*")
public class RootFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        CharacterEncodingRequest requestWrapper = new CharacterEncodingRequest(request);

        chain.doFilter(requestWrapper, response);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
