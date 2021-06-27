package com.testing.demo.Service.EventService;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Users;
import com.testing.demo.Repository.Eventrepository;
import com.testing.demo.Repository.Userrepository;
import com.testing.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    Eventrepository eventrepository;
    EventService eventService;
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Events createEvent(Events events) {
        //CREATE USER
        Events newEvent = new Events();

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

        mongoTemplate.insert(newEvent);
        //mongoTemplate
        return newEvent;

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
}
