package com.testing.demo.Repository;

import com.testing.demo.Model.Response.ApproveStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApproveStatusRepository extends MongoRepository<ApproveStatus, String> {
}
