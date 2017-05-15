package com.example.mobsoft.mobilsoftwarelab.ui.orders;

import android.util.Log;

import com.example.mobsoft.mobilsoftwarelab.interactor.order.OrderInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.order.events.GetOrdersEvent;
import com.example.mobsoft.mobilsoftwarelab.model.Order;
import com.example.mobsoft.mobilsoftwarelab.ui.Presenter;


import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobilsoftwarelab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class OrdersPresenter extends Presenter<OrdersScreen> {

    @Inject
    OrderInteractor orderInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(OrdersScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getOrders() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                orderInteractor.GetOrders();
            }
        });
    }

    public void onEventMainThread(GetOrdersEvent event) {
        Log.d("Orders presenter", "getOrders");
        if(event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if(screen != null) {
                screen.showMessage("Error: " + event.getThrowable().getMessage());
            }
            Log.e("Networking", "Error sending order", event.getThrowable());
        } else {
            if(screen != null) {
                screen.displayOrders(event.getOrders());
            }
        }
    }
}
