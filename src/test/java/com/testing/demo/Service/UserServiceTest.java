package com.testing.demo.Service;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.testing.demo.Model.Request.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}