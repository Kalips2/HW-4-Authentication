package com.example.authentication.repositories;

import com.example.authentication.model.User;
import java.util.List;
import java.util.Optional;

public interface LoginRepository {
  List<User> getAllUsers();
  Optional<User> gerUserByLogin(String login);
  boolean validateUser(String login, String password);
}
