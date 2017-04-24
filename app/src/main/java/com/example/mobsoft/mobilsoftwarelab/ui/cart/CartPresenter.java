package com.example.mobsoft.mobilsoftwarelab.ui.cart;

import com.example.mobsoft.mobilsoftwarelab.interactor.cart.CartInteractor;
import com.example.mobsoft.mobilsoftwarelab.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobilsoftwarelab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class CartPresenter extends Presenter<CartScreen> {

    @Inject
    CartInteractor cartInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public CartPresenter() {
    }

    @Override
    public void attachScreen(CartScreen screen) {
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
