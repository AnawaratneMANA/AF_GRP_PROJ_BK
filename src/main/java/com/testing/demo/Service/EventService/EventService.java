package com.testing.demo.Service.EventService;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Users;
import com.testing.demo.Model.Response.BarChartModel;

import java.util.List;

public interface EventService {
    //ADD DECLARATION OF CRUD SERVICES HERE.
    Events createEvent(Events events);
    List<Events> getAllEvents();
    Events getEventById(String id);
    String deleteEvent(String id);
    Events getEventByName(String name);
    List<BarChartModel> getCountByYear(String[] categories);
}
