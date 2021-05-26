package com.testing.demo.Model.Request;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Users{
    @Id
    private String id;
    private String firstName;
    private String lastName;
}
