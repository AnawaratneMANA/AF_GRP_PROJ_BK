package com.testing.demo.Service;

import com.testing.demo.Model.Request.Users;
import com.testing.demo.Repository.Userrepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    Userrepository userrepository;
    UserService userService;
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Users createUser(Users user) {
        //CREATE USER
        Users newUser = new Users();
        if (user.getId() == null) {
            System.out.println("this is insert");
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setUserName(user.getUserName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setType(user.getType());
            mongoTemplate.insert(newUser);
            //mongoTemplate
            return newUser;
        } else {
            System.out.println("this is update");
            newUser = mongoTemplate.findOne(new Query(where("id").is(user.getId())), Users.class);
            System.out.println("new user " + newUser);
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setUserName(user.getUserName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setType(user.getType());
            userrepository.save(newUser);
            //mongoTemplate
            return newUser;
        }

    }

    @Override
    public List<Users> getAllUsers() {
        return mongoTemplate.findAll(Users.class);
    }

    @Override
    public Users getUserById(String id) {
        Users user = mongoTemplate.findOne(new Query(where("id").is(id)), Users.class);
        return user;
    }

    @Override
    public String generateToken(Users user) {
        return null;
    }

    @Override
    public String validateUser(Users user) {
        return null;
    }

    //IMPLEMENT CRUD METHODS HERe
    @Override
    public String deleteUser(String id){
        mongoTemplate.remove(new Query(where("id").is(id)), Users.class);
        return "User id is " + id;
    }

    //Authentication Method not exposed to controllers. (Do not expose to controllers).
    @Override
    public Users getUserByName(String name) {
        Users user = null;
        try{
            user = mongoTemplate.findOne(new Query(where("userName").is(name)), Users.class);
        } catch (NullPointerException e){
            System.out.println("User is null");
        }
        return user;
    }
}
