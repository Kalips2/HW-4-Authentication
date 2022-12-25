package com.example.authentication.controllers;

import com.example.authentication.services.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
  private final LoginServiceImpl loginService;

  public UsersController(LoginServiceImpl loginService) {
    this.loginService = loginService;
  }

  @RequestMapping(value = "/users", method = {RequestMethod.GET, RequestMethod.POST})
  public String usersPage(ModelMap model) {
    model.put("users", loginService.getAllUsers());
    return "users";
  }
}
