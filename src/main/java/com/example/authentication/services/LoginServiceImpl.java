package com.example.authentication.services;

import com.example.authentication.model.User;
import com.example.authentication.repositories.LoginRepositoryImpl;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  final LoginRepositoryImpl loginRepository;

  public LoginServiceImpl(LoginRepositoryImpl loginRepository) {
    this.loginRepository = loginRepository;
  }

  public boolean validateUser(String login, String password) {
    return loginRepository.validateUser(login, password);
  }

  @Override
  public User getUserById(String login) {
    return loginRepository.gerUserByLogin(login).orElse(new User("N/A", "N/A", "N/A"));
  }

  @Override
  public List<User> getAllUsers() {
    return loginRepository.getAllUsers();
  }
}
