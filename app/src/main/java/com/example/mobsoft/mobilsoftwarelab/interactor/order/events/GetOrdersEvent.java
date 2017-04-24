package com.example.mobsoft.mobilsoftwarelab.interactor.order.events;

import com.example.mobsoft.mobilsoftwarelab.model.Order;

import java.util.List;

/**
 * Created by dkiss on 2017. 04. 24..
 */

public class GetOrdersEvent {
    private int code;
    private List<Order> orders;
    private Throwable throwable;

    public GetOrdersEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
