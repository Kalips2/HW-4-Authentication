package com.example.authentication.filters;

import com.example.authentication.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class LoggingSecurityFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws ServletException, IOException {

    var request = (HttpServletRequest) servletRequest;
    var response = (HttpServletResponse) servletResponse;

    User user = (User) request.getSession().getAttribute("user");
    String requestUrl = request.getServletPath();

    if (user != null) {
      if ("/login".equals(requestUrl)) {
        request.setAttribute("errorMessage", "You are already logged in!");
        request.getRequestDispatcher("/welcome").forward(request, response);
      }
      filterChain.doFilter(request, response);
    } else {
      request.getRequestDispatcher("/login").forward(request, response);
    }

  }
}
