package com.example.authentication.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * LogoutController is controller to receive request related to log out option.
 */
@Controller
public class LogoutController {

  /**
   * This method log out current user and return login page.
   * */
  @PostMapping("/logout")
  public void logoutPage(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    HttpSession session = request.getSession();
    session.invalidate();
    response.sendRedirect("/login");
  }
}
