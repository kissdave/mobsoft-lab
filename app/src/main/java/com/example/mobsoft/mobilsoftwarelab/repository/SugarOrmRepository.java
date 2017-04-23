package com.example.mobsoft.mobilsoftwarelab.repository;

import android.content.Context;

import com.example.mobsoft.mobilsoftwarelab.model.Order;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.model.User;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkiss on 2017. 04. 23..
 */


public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Product> getProducts() {
        return SugarRecord.listAll(Product.class);
    }

    @Override
    public void updateProducts(List<Product> products) {
        List<Product> productsInDB = getProducts();
        List<Product> toUpdate = new ArrayList<>(productsInDB.size());
        List<Product> toAdd = new ArrayList<>(productsInDB.size());
        for(Product productDB : productsInDB) {
            for( Product product : products) {
                if(product.getId().equals(productsInDB)) {
                    toUpdate.add(product);
                }
                else {
                    toAdd.add(product);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
        for(Product product : toAdd) {
            SugarRecord.save(product);
        }
    }

    @Override
    public boolean isInDB(Product product) {
        return SugarRecord.findById(Product.class, product.getId()) != null;
    }

    @Override
    public List<Order> getOrders() {
        return SugarRecord.listAll(Order.class);
    }

    @Override
    public void saveOrder(Order order) {
        SugarRecord.save(order);
    }

    @Override
    public User getSettings() {
        return SugarRecord.listAll(User.class).get(0);
    }

    @Override
    public void saveSettings(User user) {
        User userInDB = SugarRecord.findById(User.class, user.getId());
        userInDB.setName(user.getName());
        userInDB.setAddress(user.getAddress());
        userInDB.setEmail(user.getEmail());
        userInDB.setMobile(user.getMobile());
        userInDB.save();
    }
}
