package Controller;

import Repository.Userrepository;
import Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
