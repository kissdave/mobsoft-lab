package com.example.mobsoft.mobilsoftwarelab.ui.cart;

import android.util.Log;

import com.example.mobsoft.mobilsoftwarelab.interactor.cart.CartInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.cart.events.GetCartItemsEvent;
import com.example.mobsoft.mobilsoftwarelab.interactor.cart.events.SendOrderEvent;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
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

    public void getCartItems() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartInteractor.getCartItems();
            }
        });
    }

    public void sendOrder() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartInteractor.sendOrder();
            }
        });
    }

    public void onEventMainThread(GetCartItemsEvent event) {
        Log.d("Cart presenter", "getCartItems");
        if(event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if(screen != null) {
                screen.showMessage("Error: " + event.getThrowable().getMessage());
            }
            Log.e("Networking", "Error reading products", event.getThrowable());
        } else {
            if(screen != null) {
                for(Product p : event.getProducts()) {
                    screen.displayProduct(p);
                }
            }
        }
    }

    public void onEventMainThread(SendOrderEvent event) {
        Log.d("Cart presenter", "sendOrder");
        if(event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if(screen != null) {
                screen.showMessage("Error: " + event.getThrowable().getMessage());
            }
            Log.e("Networking", "Error sending order", event.getThrowable());
        } else {
            screen.showMessage("Order sent.");
        }
    }
}
