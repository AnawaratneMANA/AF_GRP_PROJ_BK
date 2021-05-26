package com.testing.demo.Service;

import com.testing.demo.Model.Request.Users;
import org.apache.catalina.User;
import java.util.List;

public interface UserService {
    //ADD DECLARATION OF CRUD SERVICES HERE.

    Users createUser(Users user);
    List<Users> getAllUsers();
    Users getUserById(String id);
    String generateToken(Users user);
    String validateUser(Users user);
}
