package com.testing.demo.Model.Request;

import java.util.ArrayList;

public class ValidateUser {
    private String UserName;
    private String password;

    public <E> ValidateUser(String userName, String password, ArrayList<E> es) {
        this.UserName = userName;
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
