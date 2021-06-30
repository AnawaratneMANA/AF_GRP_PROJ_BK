package com.testing.demo.Model.Request;

import org.springframework.data.annotation.Id;

public class KeySpeakers {
    @Id
    private String id;
    private String name;
    private String image;

    public KeySpeakers (){

    }

    public KeySpeakers(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
