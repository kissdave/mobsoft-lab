package com.example.mobsoft.mobilsoftwarelab.ui.cart;

import com.example.mobsoft.mobilsoftwarelab.model.Product;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface CartScreen {
    public void getCartItems(String text);

    public void sendOrder(String text);

    public void showMessage(String text);

    public void displayProducts(List<Product> products);

    public void removeFromCart(Product product);
}
