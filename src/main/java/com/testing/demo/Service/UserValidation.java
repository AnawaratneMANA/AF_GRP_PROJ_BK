package com.testing.demo.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserValidation implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //Process filter.
        return new User("Akash", "sdk", new ArrayList<>());
    }

    //ADD A METHOD TO GET THE USERNAME PASSWORD FROM DB.

}
