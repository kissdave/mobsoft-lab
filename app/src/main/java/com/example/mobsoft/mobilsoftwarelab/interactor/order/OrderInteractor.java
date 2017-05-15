package com.example.mobsoft.mobilsoftwarelab.interactor.order;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.interactor.order.events.GetOrdersEvent;
import com.example.mobsoft.mobilsoftwarelab.model.Order;
import com.example.mobsoft.mobilsoftwarelab.network.OrderApi;
import com.example.mobsoft.mobilsoftwarelab.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by dkiss on 2017. 04. 24..
 */

public class OrderInteractor {
    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    OrderApi orderApi;

    public OrderInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void GetOrders() {
        GetOrdersEvent event = new GetOrdersEvent();
        try {
            //List<Order> orders = repository.getOrders();
            List<Order> orders = orderApi.orderUserIdGet(repository.getSettings().getId().intValue()).execute().body();
            event.setOrders(orders);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
