package com.testing.demo.Repository;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.KeySpeakers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KeySpeakerRepositary extends MongoRepository<KeySpeakers, String> {
}
