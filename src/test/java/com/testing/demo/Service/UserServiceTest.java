package com.testing.demo.Service;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
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

import static org.junit.jupiter.api.Assertions.*;
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
    @DisplayName("Adding items and fetching items")
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
    void getUserById() {

        Users newTestingUser1 = new Users();
        newTestingUser1.setId("user123");
        newTestingUser1.setFirstName("Kamal");
        newTestingUser1.setLastName("Ekanayaka");
        newTestingUser1.setUserName("KamalaEka");
        newTestingUser1.setPassword("SDK");
        newTestingUser1.setType("admin");

        Users newTestingUser2 = new Users();
        newTestingUser2.setId("user124");
        newTestingUser2.setFirstName("Bimal");
        newTestingUser2.setLastName("Chandrasena");
        newTestingUser2.setUserName("ChanBimal");
        newTestingUser2.setPassword("SDK1");
        newTestingUser2.setType("User");

    }

    @Test
    @DisplayName("Generate token and validate users")
    void generateTokenAndValidateUser() {

    }

    @Test
    void validateUser() {

    }
    @Test
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
        //Checking
        assertEquals(newTestingUser.getFirstName(), users.get(0).getFirstName());
        mongoTemplate.remove("user123");
        //assertEquals(newTestingUser.getFirstName(), users.get(0).getFirstName());
    }
}