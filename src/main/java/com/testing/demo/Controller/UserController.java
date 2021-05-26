package com.testing.demo.Controller;
import com.testing.demo.Model.Request.Users;
import com.testing.demo.Model.Request.ValidateUser;
import com.testing.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserService userService;

    private AuthenticationManager authenticationManager;

    public UserController(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

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
    @PostMapping("/validate")
    public ResponseEntity<?> userValidation(@RequestBody ValidateUser validateUser){
        return new ResponseEntity<>("", HttpStatus.OK);
    }


   //Get Single user
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id){
        Optional<Users> userOptional = Optional.ofNullable(userService.getUserById(id));
        if(userOptional.isPresent()){
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Item not found with id " + id , HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody Users user){
        Optional<Users> userUpdate = Optional.ofNullable(userService.getUserById(id));
        if(userUpdate.isPresent()){
            Users updateUser = userUpdate.get();
            updateUser.setId(user.getId()  != null ? user.getId() : updateUser.getId());
            updateUser.setFirstName(user.getFirstName() != null ? user.getFirstName() : updateUser.getFirstName());
            updateUser.setLastName(user.getLastName() != null ? user.getLastName() : updateUser.getLastName());
            updateUser.setUserName(user.getUserName() != null ? user.getUserName() : updateUser.getUserName());
            updateUser.setPassword(user.getPassword() != null ? user.getPassword() : updateUser.getPassword());
            updateUser.setType(user.getType() != null ? user.getType() : updateUser.getType());
            userService.createUser(updateUser);
            return new ResponseEntity<>("Update Successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update Unsuccessful", HttpStatus.NOT_FOUND);
    }


}
