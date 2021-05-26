package com.testing.demo.Repository;

import com.testing.demo.Model.Request.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends MongoRepository<Users, Integer> {

}
