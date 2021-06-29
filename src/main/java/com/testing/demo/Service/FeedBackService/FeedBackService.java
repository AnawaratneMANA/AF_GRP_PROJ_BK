package com.testing.demo.Service.FeedBackService;

import com.testing.demo.Model.Request.Events;

import java.util.List;

public interface FeedBackService {
    Events createFeedback(Events events);
    List<Events> getAllEvents();
    Events getEventById(String id);
    String deleteEvent(String id);
    Events getEventByName(String name);
}
