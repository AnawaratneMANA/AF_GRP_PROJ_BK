package com.testing.demo.Service;

import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.testing.demo.Model.Request.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private static final String CONNECTION_STRING = "mongodb://%s:%d";
    private Users users;
    private UserService userService;

    //Preparing the testing environment.
    ServerAddress serverAddress = new ServerAddress("127.0.0.1", 27017);
//    MongoClient mongoClient = new MongoClient(serverAddress);
//    MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "db");

    @BeforeEach
    void setUp() {

   }

    @AfterEach
    void tearDown() {

    }

    @Test
    void createUser() {
    }

    @Test
    void getAllUsers() {
        List<String> users = List.of("firstName","lastName","userName", "pwd", "type");
        Assertions.assertEquals("firstName", users.get(0));
        Assertions.assertEquals("lastName", users.get(1));
        Assertions.assertEquals("userName", users.get(2));
        Assertions.assertEquals("pwd", users.get(3));
        Assertions.assertEquals("type", users.get(4));
    }

    @Test
    void getUserById() {

    }

    @Test
    void generateToken() {

    }

    @Test
    void validateUser() {

    }
}