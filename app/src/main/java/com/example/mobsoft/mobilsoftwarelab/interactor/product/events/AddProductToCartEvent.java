package com.example.mobsoft.mobilsoftwarelab.interactor.product.events;

import com.example.mobsoft.mobilsoftwarelab.model.Product;

/**
 * Created by dkiss on 2017. 04. 24..
 */

public class AddProductToCartEvent {
    private int code;
    private Product product;
    private Throwable throwable;

    public AddProductToCartEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
