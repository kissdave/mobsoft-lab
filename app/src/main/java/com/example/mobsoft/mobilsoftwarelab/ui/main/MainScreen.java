package com.example.mobsoft.mobilsoftwarelab.ui.main;

import com.example.mobsoft.mobilsoftwarelab.model.Product;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface MainScreen {
    public void showMessage(String text);

    public void getProducts(String text);

    public void addProductToCart(Product product);
}
