package com.testing.demo.Service.FeedBackService;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeedBackService {
    Feedback createFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    Feedback getFeedBackById(String id);
    String deleteFeedback(String id);
    Feedback getFeedbackByName(String name);
}
