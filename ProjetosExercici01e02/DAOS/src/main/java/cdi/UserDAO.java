package main.java.cdi;

public interface UserDAO {
  Integer findUserId(String user, String password);
}
