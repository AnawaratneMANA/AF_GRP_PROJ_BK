package com.testing.demo.Service.EventService;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Response.BarChartModel;
import com.testing.demo.Repository.BarChartMongoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventServiceImplTest {

    @Autowired
    BarChartMongoRepo barChartMongoRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void getCountByYear() {
        String[] types = {"Colombo"};
        Map<String, BarChartModel> responses = new HashMap<String, BarChartModel>();
        List<Events> listOfEvents = barChartMongoRepo.getItemByYear(types);
        System.out.println("Length of List Size : " + listOfEvents);
    }

    @Test
    void getAllEvents() {
        System.out.println(mongoTemplate.findAll(Events.class));
    }
}