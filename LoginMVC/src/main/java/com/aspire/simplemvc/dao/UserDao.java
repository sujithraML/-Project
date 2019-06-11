package com.aspire.simplemvc.dao;

import com.aspire.simplemvc.models.Login;
import com.aspire.simplemvc.models.User;
public interface UserDao {
  void register(User user);
  User validateUser(Login login);
}
