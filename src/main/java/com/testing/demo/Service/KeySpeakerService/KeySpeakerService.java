package com.testing.demo.Service.KeySpeakerService;

import com.testing.demo.Model.Request.KeySpeakers;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface KeySpeakerService {
    KeySpeakers createKeySpeaker(KeySpeakers keySpeakers);
    List<KeySpeakers> getAllKeySpeaker();
    KeySpeakers getKeySpeakerById(String id);
    String deleteKeySpeaker(String id);
//    Feedback getFeedbackByName(String name);
}
