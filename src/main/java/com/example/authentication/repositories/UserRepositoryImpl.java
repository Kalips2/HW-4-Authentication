package com.example.authentication.repositories;

import com.example.authentication.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * This class is repository for work with users. There are exist option on receive all users,
 * get user by Login and validate user to entering correct password and Login.
 * Password is saved as String. Currently, there is no need to encryption.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
  private List<User> users;

  /**
   * As well this class is Bean, constructor will be invoked at the beginning.
   * This constructor gives opportunity to add users on the step of initialization.
   */
  UserRepositoryImpl() {
    users = new ArrayList<>();
    users.add(new User("Admin", "admin@gmail.com", "qwerty"));
    users.add(new User("Egor Miroshnichenko", "egor1245@gmail.com", "12345678"));
    users.add(new User("Nikita Ivanov", "nikita@gmail.com", "1234321"));
    users.add(new User("Olga Chubylska", "olga@ukr.com", "qwerty1234"));
    users.add(new User("Sergiy Prityla", "usa@gmail.com", "ukraine"));
    users.add(new User("Test case", "1", "1"));
  }

  /**
   * Returns all users.
   */
  public List<User> getAllUsers() {
    return users;
  }

  /**
   * Returns user if his exist or return empty Optional.
   */
  @Override
  public Optional<User> gerUserByLogin(String login) {
    for (User user : users) {
      if (login.equals(user.getLogin())) {
        return Optional.of(user);
      }
    }
    return Optional.empty();
  }

  /**
   * Returns method return true if user passed validation, otherwise - false.
   */
  @Override
  public boolean validateUser(String login, String password) {
    for (User user : users) {
      if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
        return true;
      }
    }
    return false;
  }
}
