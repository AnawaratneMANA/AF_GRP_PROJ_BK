package com.testing.demo.Service;
import com.testing.demo.Model.Request.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserValidation implements UserDetailsService {

    //Variables
    private String username;
    private String password;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //Search the User from the DB
        Users user = userService.getUserByName(userName);
        if(user == null){
            this.username = "";
            this.password = "";
        } else {
            this.username = user.getUserName();
            this.password = user.getPassword();
        }

        //Process filter.
        return new User(username, password, new ArrayList<>());
    }

    //ADD A METHOD TO GET THE USERNAME PASSWORD FROM DB. (Done)
    //Import the repository and get the user from the database. (Validation).
    //Parse User from db to the User define from the security class.

}
