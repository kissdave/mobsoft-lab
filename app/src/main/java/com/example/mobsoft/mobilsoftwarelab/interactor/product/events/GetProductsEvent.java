package com.example.mobsoft.mobilsoftwarelab.interactor.product.events;

import com.example.mobsoft.mobilsoftwarelab.model.Product;

import java.util.List;

/**
 * Created by dkiss on 2017. 04. 24..
 */


public class GetProductsEvent {
    private int code;
    private List<Product> products;
    private Throwable throwable;

    public GetProductsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
