package com.example.authentication.filters;

import com.example.authentication.models.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 * This class is my filter component that check all URL request and give access to controllers
 * based on their authentication.
 * */
@Component
public class LoggingSecurityFilter extends GenericFilterBean {

  /**
   * The main method that do all authentication verification.
   * */
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws ServletException, IOException {

    var request = (HttpServletRequest) servletRequest;
    var response = (HttpServletResponse) servletResponse;

    User user = (User) request.getSession().getAttribute("user");
    String requestUrl = request.getServletPath();

    //If out user exist in session, meaning his is authorized, we give access to his request
    //Else sending him to login page
    if (user != null) {
      //If our user is already logged in but want again go to login page.
      //In this case we return base page - welcome with sign of errorMessage.
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
