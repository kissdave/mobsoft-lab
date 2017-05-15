package com.example.mobsoft.mobilsoftwarelab.model;

import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class Order extends SugarRecord {
//    private Long id = null;
    private Date orderTime;
    private User user;
    private List<Product> items;

    public Order() {
    }

    public Order(Long id, Date orderTime, User user, List<Product> items) {
  //      this.id = id;
        this.orderTime = orderTime;
        this.user = user;
        this.items = items;
    }

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }
}
