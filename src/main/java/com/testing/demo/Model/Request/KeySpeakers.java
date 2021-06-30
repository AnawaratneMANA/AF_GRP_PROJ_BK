package com.testing.demo.Model.Request;

import org.springframework.data.annotation.Id;

public class KeySpeakers {
    @Id
    private String id;
    private String name;
    private String image;
    private String qualifications;

    public KeySpeakers (){

    }

    public KeySpeakers(String id, String name, String image, String qualifications) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.qualifications = qualifications;
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

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
}
