package com.testing.demo.Service.EventService;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Users;
import com.testing.demo.Model.Response.BarChartModel;
import com.testing.demo.Repository.BarChartMongoRepo;
import com.testing.demo.Repository.Eventrepository;
import com.testing.demo.Repository.Userrepository;
import com.testing.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    Eventrepository eventrepository;

    @Autowired
    EventService eventService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BarChartMongoRepo barChartMongoRepo;

    @Override
    public Events createEvent(Events events) {
        Events newEvent = new Events();
        if (events.getId() == null) {
            newEvent.setEventName(events.getEventName());
            newEvent.setEventType(events.getEventType());
            newEvent.setDescription(events.getDescription());
            newEvent.setEventPlace(events.getEventPlace());
            newEvent.setSponsor(events.getSponsor());
            newEvent.setOrganizerName(events.getOrganizerName());
            newEvent.setStatus(events.getStatus());
            newEvent.setLimitOfPeople(events.getLimitOfPeople());
            newEvent.setMainSpeaker(events.getMainSpeaker());
            newEvent.setDatetime(events.getDatetime());
            newEvent.setImage(events.getImage());
            mongoTemplate.insert(newEvent);
            return newEvent;
        } else {
            System.out.println("this is update");
            newEvent = mongoTemplate.findOne(new Query(where("id").is(events.getId())), Events.class);
            newEvent.setEventName(events.getEventName());
            newEvent.setEventType(events.getEventType());
            newEvent.setDescription(events.getDescription());
            newEvent.setEventPlace(events.getEventPlace());
            newEvent.setSponsor(events.getSponsor());
            newEvent.setOrganizerName(events.getOrganizerName());
            newEvent.setStatus(events.getStatus());
            newEvent.setLimitOfPeople(events.getLimitOfPeople());
            newEvent.setMainSpeaker(events.getMainSpeaker());
            newEvent.setDatetime(events.getDatetime());
            newEvent.setImage(events.getImage());
            eventrepository.save(newEvent);
            return newEvent;
        }

    }

    @Override
    public List<Events> getAllEvents() {
        return mongoTemplate.findAll(Events.class);
    }

    @Override
    public Events getEventById(String id) {
        Events events = mongoTemplate.findOne(new Query(where("id").is(id)), Events.class);
        System.out.println(events);
        return events;
    }

    @Override
    public String deleteEvent(String id) {
        mongoTemplate.remove(new Query(where("id").is(id)), Events.class);
        return "Event id is " + id;
    }

    @Override
    public Events getEventByName(String name) {
       Events events = null;
        try{
            events = mongoTemplate.findOne(new Query(where("eventName").is(name)), Events.class);
        } catch (NullPointerException e){
            System.out.println("User is null");
        }
        return events;
    }

    @Override
    public List<BarChartModel> getCountByYear(String[] categories) {
        Map<String, BarChartModel> responses = new HashMap<String, BarChartModel>();
        List<Events> listOfEvents = barChartMongoRepo.getItemByYear(categories);
        System.out.println(listOfEvents);
        return null;

        //Something is wrong. Check.
    }
}
