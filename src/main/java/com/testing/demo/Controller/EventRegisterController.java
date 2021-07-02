package com.testing.demo.Controller;

import com.testing.demo.Service.EventRegisterService;
import com.testing.demo.Service.EventService.EventService;
import com.testing.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class EventRegisterController {

//    @Autowired
//    //EventRegisterService eventRegisterService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    private AuthenticationManager authenticationManager;
//
//    public EventController(){
//
//    }


}
