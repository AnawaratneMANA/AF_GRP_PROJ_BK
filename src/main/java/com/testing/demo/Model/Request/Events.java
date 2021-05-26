package com.testing.demo.Model.Request;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Events {
    @Id
    private String id;
    private String eventName;
    private String eventPlace;
    private Date datetime;
    private String conductorId;

}
