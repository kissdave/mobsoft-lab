package com.example.mobsoft.mobilsoftwarelab.repository;

import android.content.Context;

import com.example.mobsoft.mobilsoftwarelab.model.Order;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dkiss on 2017. 04. 23..
 */

public class MemoryRepository implements Repository {
    private static final long MINUTE = 60 * 1000;

    private static List<Order> orders;
    private static List<Product> products;
    private static List<User> users;

    @Override
    public void open(Context context) {
        products = new ArrayList<>();
        products.add(new Product(1L, "Hawaii pizza", "(pizzaszósz, ananász, sonka, sajt)", 1090));
        products.add(new Product(3L, "Szalámis pizza", "(pizzaszósz, téliszalámi, sajt)", 1390));

        User user = new User(1L, "Kiss Dávid", "kiss.david@simonyi.bme.hu", "+36 30 123 4567", "1117 Budapest, Irinyi J. út 42.");
        users = new ArrayList<>();
        users.add(user);

        orders.add(new Order(1L, new Date(2017, 4, 23), user, products));
    }

    @Override
    public void close() {

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void updateProducts(List<Product> products) {
        this.products.clear();
        this.products = products;
    }

    @Override
    public boolean isInDB(Product product) {
        return products.contains(product);
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        orders.add(order);
    }

    @Override
    public User getSettings() {
        return users.get(0);
    }

    @Override
    public void saveSettings(User user) {
        User old = users.get(0);
        users.clear();

        user.setId(old.getId());
        users.add(user);
    }
}
