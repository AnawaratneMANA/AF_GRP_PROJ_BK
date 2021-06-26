package com.testing.demo.Repository;

import com.testing.demo.Model.Response.TotalUserCount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TotalUserCountRepository  extends MongoRepository<TotalUserCount, String> {
}
