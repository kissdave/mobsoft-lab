package com.example.mobsoft.mobilsoftwarelab.ui.orders;

import com.example.mobsoft.mobilsoftwarelab.interactor.order.OrderInteractor;
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

    public OrdersPresenter() {
    }

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
}
