package org.example.servlet.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (urlPatterns = "/*")
public class CustomSecurityServlet implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path =request.getRequestURI();

        Object loggedInUser = request.getSession().getAttribute("loggedInUser");

        if (((path.contains("jsp")) && loggedInUser == null )) {
            response.sendRedirect("login");
            return;
        }

        if (path.contains("login") || path.contains("css") || path.contains("js")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        if (loggedInUser == null) {
            response.sendRedirect("login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }



    }
}
