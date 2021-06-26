package com.testing.demo.Model.Response;

import org.springframework.data.annotation.Id;

public class TotalUserCount {
    @Id
    private String Id;
    private String totalUserCount;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTotalUserCount() {
        return totalUserCount;
    }

    public void setTotalUserCount(String totalUserCount) {
        this.totalUserCount = totalUserCount;
    }
}
