package com.testing.demo.Service.KeySpeakerService;

import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Model.Request.KeySpeakers;

import java.util.List;

public interface KeySpeakerService {
    KeySpeakers createKeySpeaker(KeySpeakers keySpeakers);
    List<Feedback> getAllKeySpeaker();
    KeySpeakers getKeySpeakerById(String id);
    String deleteKeySpeaker(String id);
//    Feedback getFeedbackByName(String name);
}
