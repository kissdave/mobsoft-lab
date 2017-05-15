package com.example.mobsoft.mobilsoftwarelab.interactor.product;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.interactor.product.events.AddProductToCartEvent;
import com.example.mobsoft.mobilsoftwarelab.interactor.product.events.GetProductsEvent;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.network.ProductApi;
import com.example.mobsoft.mobilsoftwarelab.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by dkiss on 2017. 04. 24..
 */

public class ProductsInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    ProductApi productApi;

    public ProductsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getProducts() {
        GetProductsEvent event = new GetProductsEvent();
        try {
            //List<Product> products = repository.getProducts();
            List<Product> products = productApi.productsGet().execute().body();
            event.setProducts(products);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void addProductToCart(Product product) {
        AddProductToCartEvent event = new AddProductToCartEvent();
        event.setProduct(product);
        try {
            repository.addProductToCart(product);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }

    }
}
