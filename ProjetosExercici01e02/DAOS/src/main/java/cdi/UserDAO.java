package main.java.cdi;

import main.java.entitie.User;

public interface UserDAO {
  Integer findUserId(String user, String password);

Integer addUser(User user);
}
