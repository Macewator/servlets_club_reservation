package pl.arizona.club.filter;

import pl.arizona.club.model.User;
import pl.arizona.club.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class SessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if(request.getUserPrincipal() != null && request.getSession().getAttribute("user") == null){
            saveUserInSession(request);
        }
        chain.doFilter(req, resp);
    }

    private void saveUserInSession(HttpServletRequest request) {
        UserService userService = new UserService();
        String username = request.getUserPrincipal().getName();
        User user = userService.createUsersSession(username);
        request.getSession(true).setAttribute("user", user);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
