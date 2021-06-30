package com.testing.demo.Repository;

import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Model.Request.KeySpeakers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedBackRepositary extends MongoRepository<Feedback, String> {
}
