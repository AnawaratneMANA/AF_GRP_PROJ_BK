package com.testing.demo.Model.Request;

import org.springframework.data.annotation.Id;

public class ResearchPaper {

    @Id
    private String id;
    private String fileName;
    private String path;
    private String publisherId;
    private String category;
}
