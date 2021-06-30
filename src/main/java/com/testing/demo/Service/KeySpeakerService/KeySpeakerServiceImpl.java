package com.testing.demo.Service.KeySpeakerService;

import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Model.Request.KeySpeakers;
import com.testing.demo.Repository.BarChartMongoRepo;
import com.testing.demo.Repository.Eventrepository;
import com.testing.demo.Repository.KeySpeakerRepositary;
import com.testing.demo.Service.EventService.EventService;
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
        return null;
    }

    @Override
    public List<Feedback> getAllKeySpeaker() {
        return null;
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
