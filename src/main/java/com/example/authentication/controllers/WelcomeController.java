package com.example.authentication.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
  @GetMapping("/welcome")
  public String welcomePage(ModelMap model, HttpServletRequest request) {
    model.put("user", request.getSession().getAttribute("user"));
    model.put("errorMessage", request.getAttribute("errorMessage"));
    return "welcome";
  }
}
