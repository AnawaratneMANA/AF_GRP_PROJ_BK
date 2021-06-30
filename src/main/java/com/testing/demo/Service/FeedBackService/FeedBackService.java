package com.testing.demo.Service.FeedBackService;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Feedback;

import java.util.List;

public interface FeedBackService {
    Feedback createFeedback(Feedback feedback);
    List<Events> getAllFeedbacks();
    Feedback getFeedBackById(String id);
    String deleteFeedback(String id);
    Feedback getFeedbackByName(String name);
}
