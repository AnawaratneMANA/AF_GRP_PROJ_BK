package com.testing.demo.Controller;

import com.testing.demo.Model.Request.Events;
import com.testing.demo.Model.Request.Feedback;
import com.testing.demo.Service.EventService.EventService;
import com.testing.demo.Service.FeedBackService.FeedBackService;
import com.testing.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class FeedBackController {
    @Autowired
    FeedBackService feedBackService;

    @Autowired
    private JwtUtil jwtUtil;

    public FeedBackController(){

    }

    @PostMapping("/feedback")
    public ResponseEntity<?> createFeedback (@RequestBody Feedback feedback){
        Feedback addedFeedback = feedBackService.createFeedback(feedback);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

//    @GetMapping("/events")
//    public ResponseEntity<?> getAllEvents(){
//        List<Events> events = eventService.getAllEvents();
//        if(events.size() > 0){
//            return new ResponseEntity<>(events, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("No Events", HttpStatus.NOT_FOUND);
//        }
//    }


//    //Get Single event
//    @GetMapping("/getEventById/{id}")
//    public ResponseEntity<?> getEventById(@PathVariable("id") String id){
//        Optional<Events> eventOptional = Optional.ofNullable(eventService.getEventById(id));
//        if(eventOptional.isPresent()){
//            return new ResponseEntity<>(eventOptional.get(), HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>("Event not found with id " + id , HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/updateEvent/{id}")
//    public ResponseEntity<?> updateEvent(@PathVariable("id") String id, @RequestBody Events events){
//        Optional<Events> eventUpdate = Optional.ofNullable(eventService.getEventById(id));
//        if(eventUpdate.isPresent()){
//            Events updateEvent = eventUpdate.get();
//            updateEvent.setId(events.getId() != null ? events.getId() : updateEvent.getId());
//            updateEvent.setEventName(events.getEventName() != null ? events.getEventName() : updateEvent.getEventName());
//            updateEvent.setEventType(events.getEventType() != null ? events.getEventType() : updateEvent.getEventType());
//            updateEvent.setEventPlace(events.getEventPlace() != null ? events.getEventPlace() : updateEvent.getEventPlace());
//            updateEvent.setDescription(events.getDescription() != null ? events.getDescription() : updateEvent.getDescription());
//            updateEvent.setStatus(events.getStatus() != null ? events.getStatus() : updateEvent.getStatus());
//            updateEvent.setDatetime(events.getDatetime() != null ? events.getDatetime() : updateEvent.getDatetime());
//            updateEvent.setMainSpeaker(events.getMainSpeaker() != null ? events.getMainSpeaker() : updateEvent.getMainSpeaker());
//            updateEvent.setLimitOfPeople(events.getLimitOfPeople() != null ? events.getLimitOfPeople() : updateEvent.getLimitOfPeople());
//            updateEvent.setOrganizerName(events.getOrganizerName() != null ? events.getOrganizerName() : updateEvent.getOrganizerName());
//
//            eventService.createEvent(updateEvent);
//            return new ResponseEntity<>("Update Successful", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Update Unsuccessful", HttpStatus.NOT_FOUND);
//    }

//    @DeleteMapping("/deleteEvent/{id}")
//    public ResponseEntity<?> deleteEvent(@PathVariable String id){
//        String response = eventService.deleteEvent(id);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

}
