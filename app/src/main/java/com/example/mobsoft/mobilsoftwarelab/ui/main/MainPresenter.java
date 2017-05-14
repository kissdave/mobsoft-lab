package com.example.mobsoft.mobilsoftwarelab.ui.main;

import android.util.Log;

import com.example.mobsoft.mobilsoftwarelab.interactor.product.ProductsInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.product.events.AddProductToCartEvent;
import com.example.mobsoft.mobilsoftwarelab.interactor.product.events.GetProductsEvent;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobilsoftwarelab.MobSoftApplication.injector;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    ProductsInteractor productsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getProducts() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                productsInteractor.getProducts();
            }
        });
    }

    public void addProductToCart(final Product product) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                productsInteractor.addProductToCart(product);
            }
        });
    }

    public void onEventMainThread(GetProductsEvent event) {
        Log.d("Main presenter", "getProducts");
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

    public void onEventMainThread(AddProductToCartEvent event) {
        Log.d("Main presenter", "addProductToCart");
        if(event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if(screen != null) {
                screen.showMessage("Error: " + event.getThrowable().getMessage());
            }
            Log.e("Networking", "Error adding product to cart", event.getThrowable());
        } else {
            if(screen != null) {
                screen.showMessage("Product added to cart." + event.getProduct().getName());
            }
        }
    }

}