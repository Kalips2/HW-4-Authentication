package com.example.authentication.controllers;

import com.example.authentication.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * UsersController is controller to receive all request related to users page.
 * Also, controller processes request using userService with according methods.
 * */
@Controller
public class UsersController {
  private final UserServiceImpl userService;

  public UsersController(UserServiceImpl loginService) {
    this.userService = loginService;
  }

  /**
   * Returns page with all users
   * */
  @RequestMapping(value = "/users", method = {RequestMethod.GET, RequestMethod.POST})
  public String usersPage(ModelMap model) {
    model.put("users", userService.getAllUsers());
    return "users";
  }
}
