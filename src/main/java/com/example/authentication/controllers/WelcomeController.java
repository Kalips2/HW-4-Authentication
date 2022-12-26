package com.example.authentication.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * WelcomeController is controller to receive request related to welcome page.
 */
@Controller
public class WelcomeController {
  /**
   * Returns welcome page with parameters users and errorMessage. The latter will not necessarily always be.
   */
  @GetMapping("/welcome")
  public String welcomePage(ModelMap model, HttpServletRequest request) {
    model.put("user", request.getSession().getAttribute("user"));
    model.put("errorMessage", request.getAttribute("errorMessage"));
    return "welcome";
  }
}
