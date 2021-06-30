package com.testing.demo.Service.KeySpeakerService;

import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Model.Request.KeySpeakers;
import com.testing.demo.Repository.BarChartMongoRepo;
import com.testing.demo.Repository.KeySpeakerRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
@Service
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
        KeySpeakers keySpeakers = mongoTemplate.findOne(new Query(where("id").is(id)), KeySpeakers.class);
        System.out.println(keySpeakers);
        return keySpeakers;
    }

    @Override
    public String deleteKeySpeaker(String id) {
        mongoTemplate.remove(new Query(where("id").is(id)), KeySpeakers.class);
        return "KeySpeaker id is " + id;
    }
}
