package com.example.authentication.repositories;

import com.example.authentication.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository{
  private List<User> users;

  LoginRepositoryImpl() {
    users = new ArrayList<>();
    users.add(new User("Admin", "admin@gmail.com", "qwerty"));
    users.add(new User("Egor Miroshnichenko", "egor1245@gmail.com", "12345678"));
    users.add(new User("Nikita Ivanov", "nikita@gmail.com", "1234321"));
    users.add(new User("Olga Chubylska", "olga@ukr.com", "qwerty1234"));
    users.add(new User("Sergiy Prityla", "usa@gmail.com", "ukraine"));
    users.add(new User("Test case", "1", "1"));
  }

  public List<User> getAllUsers() {
    return users;
  }

  @Override
  public Optional<User> gerUserByLogin(String login) {
    for(User user : users) {
      if (login.equals(user.getLogin()))
          return Optional.of(user);
    }
    return Optional.empty();
  }

  @Override
  public boolean validateUser(String login, String password) {
    for(User user : users) {
      if (login.equals(user.getLogin()) && password.equals(user.getPassword()))
        return true;
    }
    return false;
  }
}
