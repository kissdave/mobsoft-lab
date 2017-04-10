package com.example.mobsoft.mobilsoftwarelab.repository;

import android.content.Context;

import com.example.mobsoft.mobilsoftwarelab.model.Order;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.model.User;

import java.util.List;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Product> getProducts();

    boolean isInDB(Product product);

    List<Order> getOrders();

    User getSettings();

    void saveSettings(User user);
}
