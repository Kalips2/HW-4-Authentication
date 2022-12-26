package com.example.authentication.services;

import com.example.authentication.models.User;
import java.util.List;

public interface UserService {
  boolean validateUser(String login, String password);
  User getUserById(String login);
  List<User> getAllUsers();


}
