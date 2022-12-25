package com.example.authentication.controllers;

import com.example.authentication.model.User;
import com.example.authentication.services.LoginServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  private final LoginServiceImpl loginService;

  public LoginController(LoginServiceImpl loginService) {
    this.loginService = loginService;
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String welcomePage(ModelMap model, @RequestParam String login,
                            @RequestParam String password,
                            HttpServletResponse response, HttpServletRequest request)
      throws IOException {
    boolean isValid = loginService.validateUser(login, password);
    if (!isValid) {
      model.put("errorMessage", "Incorrect login or password! Try again!");
      return "login";
    }
    User currentUser = loginService.getUserById(login);
    HttpSession session = request.getSession();
    session.setAttribute("user", currentUser);

    response.sendRedirect("/welcome");
    return "welcome";
  }

}
