package com.example.authentication.services;

import com.example.authentication.model.User;
import java.util.List;
import java.util.Optional;

public interface LoginService {
  boolean validateUser(String login, String password);
  User getUserById(String login);
  List<User> getAllUsers();


}
