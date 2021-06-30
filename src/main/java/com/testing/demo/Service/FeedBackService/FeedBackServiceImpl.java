package com.testing.demo.Service.FeedBackService;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Repository.BarChartMongoRepo;
import com.testing.demo.Repository.Eventrepository;
import com.testing.demo.Repository.FeedBackRepositary;
import com.testing.demo.Service.EventService.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class FeedBackServiceImpl implements FeedBackService{
    @Autowired
    FeedBackRepositary feedBackRepositary;

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
        Feedback feedback = mongoTemplate.findOne(new Query(where("id").is(id)), Feedback.class);
        System.out.println(feedback);
        return feedback;
    }

    @Override
    public String deleteFeedback(String id) {
        mongoTemplate.remove(new Query(where("id").is(id)), Feedback.class);
        return "Feedback id is " + id;
    }

    @Override
    public Feedback getFeedbackByName(String name) {
        Feedback feedback = null;
        try{
            feedback = mongoTemplate.findOne(new Query(where("feedBackName").is(name)), Feedback.class);
        } catch (NullPointerException e){
            System.out.println("Feedback is null");
        }
        return feedback;
    }
}
