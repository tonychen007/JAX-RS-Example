package com.tony.shop.domain;

import javax.ws.rs.FormParam;

public class TestBean {
    @FormParam("last")
    String lastname;

    @FormParam("first")
    String firstname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
