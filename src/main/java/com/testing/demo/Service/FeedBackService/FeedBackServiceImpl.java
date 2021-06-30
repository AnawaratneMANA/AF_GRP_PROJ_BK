package com.testing.demo.Service.FeedBackService;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Repository.BarChartMongoRepo;
import com.testing.demo.Repository.Eventrepository;
import com.testing.demo.Service.EventService.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService{
    @Autowired
    Eventrepository eventrepository;

    @Autowired
    EventService eventService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BarChartMongoRepo barChartMongoRepo;

    @Override
    public Feedback createFeedback(Feedback feedback) {
        Feedback newFeedBack = new Feedback();
        newFeedBack.setName(feedback.getName());
        newFeedBack.setFeedback(feedback.getFeedback());
        newFeedBack.setRating(feedback.getRating());

        mongoTemplate.insert(newFeedBack);
        return newFeedBack;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return mongoTemplate.findAll(Feedback.class);
    }

    @Override
    public Feedback getFeedBackById(String id) {
        return null;
    }

    @Override
    public String deleteFeedback(String id) {
        return null;
    }

    @Override
    public Feedback getFeedbackByName(String name) {
        return null;
    }
}
