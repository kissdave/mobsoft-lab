package com.example.mobsoft.mobilsoftwarelab.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by mobsoft on 2017. 04. 10..
 */
@Table
public class User extends SugarRecord {
    private Long id = null;
    private String name;
    private String email;
    private String mobile;
    private String address;

    public User() {
    }

    public User(Long id, String name, String email, String mobile, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
