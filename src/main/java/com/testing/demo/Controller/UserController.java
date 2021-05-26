package com.testing.demo.Controller;
import com.testing.demo.Model.Request.Users;
import com.testing.demo.Service.UserService;
import com.testing.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser (@RequestBody Users user){
       Users addedUser = userService.createUser(user);
       return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<Users> users = userService.getAllUsers();
        if(users.size() > 0){
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Users", HttpStatus.NOT_FOUND);
        }
    }

    //VALIDATION METHOD.
}
