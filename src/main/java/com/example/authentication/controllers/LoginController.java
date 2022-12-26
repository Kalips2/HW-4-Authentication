package com.example.authentication.controllers;

import com.example.authentication.models.User;
import com.example.authentication.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * LoginController is controller to receive all request related to login page.
 * Also, controller processes request using userService with according methods.
 * */
@Controller
public class LoginController {

  private final UserServiceImpl userService;

  public LoginController(UserServiceImpl loginService) {
    this.userService = loginService;
  }

  /**
   * Returns login page.
   * */
  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  /**
   * Returns login page if user entered incorrect password or login (he doesn't exist).
   * Returns welcome page if user passed authentication validation.
   * */
  @PostMapping("/login")
  public String welcomePage(ModelMap model, @RequestParam String login,
                            @RequestParam String password,
                            HttpServletResponse response, HttpServletRequest request)
      throws IOException {
    boolean isValid = userService.validateUser(login, password);
    if (!isValid) {
      model.put("errorMessage", "Incorrect login or password! Try again!");
      return "login";
    }

    //This is calls when user is existed. We need to add this user to session.
    // It's marking that user is authorized.
    User currentUser = userService.getUserById(login);
    HttpSession session = request.getSession();
    session.setAttribute("user", currentUser);

    response.sendRedirect("/welcome");
    return "welcome";
  }

}
