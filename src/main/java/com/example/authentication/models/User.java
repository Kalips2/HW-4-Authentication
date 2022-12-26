package com.example.authentication.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
/**
 * Model of user. Contains all information about him.
 * In our application Login act as Id.
 * */
public class User {
  String name;
  String login;
  String password;
}
