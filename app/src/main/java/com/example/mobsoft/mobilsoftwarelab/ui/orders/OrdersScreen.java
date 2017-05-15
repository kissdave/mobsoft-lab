package com.example.mobsoft.mobilsoftwarelab.ui.orders;

import com.example.mobsoft.mobilsoftwarelab.model.Order;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public interface OrdersScreen {
    public void getOrders(String text);

    public void showMessage(String text);

    public void displayOrders(List<Order> orders);
}
