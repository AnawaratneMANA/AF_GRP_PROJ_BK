package com.testing.demo.Model.Request;

import org.springframework.data.annotation.Id;

public class Feedback {
    @Id
    private String id;
    private String name;
    private String feedback;
    private String rating;

    public Feedback(){

    }

    public Feedback(String id, String name, String feedback, String rating) {
        this.id = id;
        this.name = name;
        this.feedback = feedback;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
