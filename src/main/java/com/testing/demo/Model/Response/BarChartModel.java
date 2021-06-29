package com.testing.demo.Model.Response;

public class BarChartModel {
    private String year;
    private int value;

    public BarChartModel(String year, int value) {
        this.year = year;
        this.value = value;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
