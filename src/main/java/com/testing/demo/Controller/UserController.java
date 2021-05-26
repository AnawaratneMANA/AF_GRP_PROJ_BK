package com.testing.demo.Controller;
import com.testing.demo.Repository.Userrepository;
import com.testing.demo.Model.Request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private Userrepository uRepo;

    @PostMapping("/user")
    public ResponseEntity<?> createUser (@RequestBody Users user){
        try{
            uRepo.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
