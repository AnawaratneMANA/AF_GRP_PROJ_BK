package com.testing.demo.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
public class Users{
    @Id
    private String id;
    private String firstName;
    private String lastName;
}
