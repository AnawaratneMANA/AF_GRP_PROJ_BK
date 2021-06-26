package com.testing.demo.Service;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.testing.demo.Model.Request.Users;
import com.testing.demo.Model.Response.jwtTockenResponse;
import com.testing.demo.util.JwtUtil;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

class UserServiceTest {

    private static final String CONNECTION = "mongodb://%s:%d";

    private MongodExecutable mongodExecutable;
    private MongoTemplate mongoTemplate;
    private UserService userService;

    @AfterEach
    void tearDown() {
        mongodExecutable.stop();
    }

    @BeforeEach
    void setup() throws Exception{

        String ip = "localhost";
        int port = 27017;


        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
                .net(new Net(ip, port, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
        mongoTemplate = new MongoTemplate(MongoClients.create(String.format(CONNECTION, ip, port)), "test");
    }

    @Test
    @DisplayName("Creating Users testing Method")
    void createUser() {
        //Inserting Data.
        Users newTestingUser = new Users();
        newTestingUser.setId("1");
        newTestingUser.setFirstName("Kamal");
        newTestingUser.setLastName("Ekanayaka");
        newTestingUser.setUserName("KamalaEka");
        newTestingUser.setPassword("SDK");
        newTestingUser.setType("admin");
        mongoTemplate.insert(newTestingUser);
        //Fetching Data
        List<Users> users = mongoTemplate.findAll(Users.class);
        //Checking
        assertEquals(newTestingUser.getFirstName(), users.get(0).getFirstName());
    }

    @Test
    @DisplayName("Check getAllUsers method and Calculate the total users")
    void getAllUsers() {
        //Create empty user
        for(int i=0; i<3; i++){
            Users newTestingUser = new Users();
            mongoTemplate.insert(newTestingUser);
        }

        //Fetching All users and Count
        List<Users> users = mongoTemplate.findAll(Users.class);
        assertEquals(3, users.size());
        assertNotNull(users.size());
    }

    @Test
    @DisplayName("Get User By Id Method testing method.")
    void getUserById() {

        Users newTestingUser1 = new Users();
        newTestingUser1.setId("user123");
        newTestingUser1.setFirstName("Kamal");
        newTestingUser1.setLastName("Ekanayaka");
        newTestingUser1.setUserName("KamalaEka");
        newTestingUser1.setPassword("SDK");
        newTestingUser1.setType("admin");
        mongoTemplate.insert(newTestingUser1);

        Users newTestingUser2 = new Users();
        newTestingUser2.setId("user124");
        newTestingUser2.setFirstName("Bimal");
        newTestingUser2.setLastName("Chandrasena");
        newTestingUser2.setUserName("ChanBimal");
        newTestingUser2.setPassword("SDK1");
        newTestingUser2.setType("User");
        mongoTemplate.insert(newTestingUser2);

        Users user = mongoTemplate.findOne(new Query(where("id").is("user124")), Users.class);
        assertEquals(user.getFirstName(), newTestingUser2.getFirstName());
    }

    @Test
    @DisplayName("Delete method testing")
    void deleteUser(){
        Users newTestingUser = new Users();
        newTestingUser.setId("user123");
        newTestingUser.setFirstName("Kamal");
        newTestingUser.setLastName("Ekanayaka");
        newTestingUser.setUserName("KamalaEka");
        newTestingUser.setPassword("SDK");
        newTestingUser.setType("admin");
        mongoTemplate.insert(newTestingUser);
        List<Users> users = mongoTemplate.findAll(Users.class);
        DeleteResult y = mongoTemplate.remove(new Query(where("id").is("user123")), Users.class);
        assertEquals(1, y.getDeletedCount());

    }

    @Test
    @DisplayName("Get user by name method testing")
    void getUserByName(){

        Users newTestingUser1 = new Users();
        newTestingUser1.setId("user123");
        newTestingUser1.setFirstName("Kamal");
        newTestingUser1.setLastName("Ekanayaka");
        newTestingUser1.setUserName("Salitha");
        newTestingUser1.setPassword("SDK");
        newTestingUser1.setType("admin");
        mongoTemplate.insert(newTestingUser1);
        Users user = null;
        try{
            user = mongoTemplate.findOne(new Query(where("userName").is("Salitha")), Users.class);
        } catch (NullPointerException e){
            System.out.println("User Name is Null");
        }

        System.out.println(user);
        assertEquals(user.getFirstName(), newTestingUser1.getFirstName());
    }
}