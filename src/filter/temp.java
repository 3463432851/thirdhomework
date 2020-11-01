package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "the_Filter",urlPatterns = {"/addServlet/*","/logoutServlet/*","/doneServlet/*"})
public class temp implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            chain.doFilter(req, resp);
        }
        else{
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
    }
    public void init(FilterConfig config) throws ServletException {
    }
}