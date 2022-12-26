package com.example.authentication.services;

import com.example.authentication.models.User;
import com.example.authentication.repositories.UserRepositoryImpl;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * This class is service for work with users. There are exist option on receive all users,
 * get user by Login and validate user to entering correct password and Login.
 */
@Service
public class UserServiceImpl implements UserService {

  final UserRepositoryImpl loginRepository;

  public UserServiceImpl(UserRepositoryImpl loginRepository) {
    this.loginRepository = loginRepository;
  }

  /**
   * Returns method return true if user passed validation, otherwise - false.
   */
  public boolean validateUser(String login, String password) {
    return loginRepository.validateUser(login, password);
  }

  /**
   * Returns user if his exist or return a new User with "N/A" as fields. Simple stub if something will get wrong.
   */
  @Override
  public User getUserById(String login) {
    return loginRepository.gerUserByLogin(login).orElse(new User("N/A", "N/A", "N/A"));
  }

  /**
   * Returns all users.
   */
  @Override
  public List<User> getAllUsers() {
    return loginRepository.getAllUsers();
  }
}
