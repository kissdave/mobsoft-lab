package com.example.mobsoft.mobilsoftwarelab.interactor.cart;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.interactor.cart.events.GetCartItemsEvent;
import com.example.mobsoft.mobilsoftwarelab.interactor.cart.events.RemoveFromCartEvent;
import com.example.mobsoft.mobilsoftwarelab.interactor.cart.events.SendOrderEvent;
import com.example.mobsoft.mobilsoftwarelab.model.Order;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.network.OrderApi;
import com.example.mobsoft.mobilsoftwarelab.repository.Repository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by dkiss on 2017. 04. 24..
 */

public class CartInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    OrderApi orderApi;

    public CartInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCartItems() {
        GetCartItemsEvent event = new GetCartItemsEvent();
        try {
            List<Product> products = repository.GetProductsFromCart();
            event.setProducts(products);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void sendOrder() {
        SendOrderEvent event = new SendOrderEvent();
        try {
            List<Product> productList = repository.GetProductsFromCart();
            orderApi.orderPost(new Order(1L, new Date(), repository.getSettings(), productList));
            event.setProducts(productList);
            repository.clearCart();
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void removeFromCart(Product product) {
        RemoveFromCartEvent event = new RemoveFromCartEvent();
        try {
            repository.removeFromCart(product);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
