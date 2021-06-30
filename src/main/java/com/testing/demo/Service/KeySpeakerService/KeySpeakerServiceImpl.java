package com.testing.demo.Service.KeySpeakerService;

import com.testing.demo.Model.Request.KeySpeakers;
import com.testing.demo.Repository.BarChartMongoRepo;
import com.testing.demo.Repository.KeySpeakerRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class KeySpeakerServiceImpl implements KeySpeakerService{
    @Autowired
    KeySpeakerRepositary keySpeakerRepositary;

    @Autowired
    KeySpeakerService keySpeakerService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BarChartMongoRepo barChartMongoRepo;


    @Override
    public KeySpeakers createKeySpeaker(KeySpeakers keySpeakers) {
        KeySpeakers newKeySpeaker = new KeySpeakers();
        newKeySpeaker.setName(keySpeakers.getName());
        newKeySpeaker.setQualifications(keySpeakers.getQualifications());
        newKeySpeaker.setImage(keySpeakers.getImage());

        mongoTemplate.insert(newKeySpeaker);
        return newKeySpeaker;
    }

    @Override
    public List<KeySpeakers> getAllKeySpeaker() {
        return mongoTemplate.findAll(KeySpeakers.class);
    }

    @Override
    public KeySpeakers getKeySpeakerById(String id) {
        return null;
    }

    @Override
    public String deleteKeySpeaker(String id) {
        return null;
    }
}
