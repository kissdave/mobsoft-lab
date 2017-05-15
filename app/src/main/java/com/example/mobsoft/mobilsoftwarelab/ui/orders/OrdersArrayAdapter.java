package com.example.mobsoft.mobilsoftwarelab.ui.orders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mobsoft.mobilsoftwarelab.R;
import com.example.mobsoft.mobilsoftwarelab.model.Order;
import com.example.mobsoft.mobilsoftwarelab.model.Product;

import java.util.List;

/**
 * Created by dkiss on 2017. 05. 15..
 */

public class OrdersArrayAdapter extends ArrayAdapter<Order> {
    private Context context;
    private List<Order> orderList;

    public OrdersArrayAdapter(Context context, List<Order> orders) {
        super(context, -1, orders);
        this.context = context;
        this.orderList = orders;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout_order, parent, false);
        TextView orderDate = (TextView)rowView.findViewById(R.id.order_time);
        TextView orderAddress = (TextView)rowView.findViewById(R.id.order_address);
        TextView orderItems = (TextView)rowView.findViewById(R.id.order_items);

        orderDate.setText("Rendelés ideje: " + orderList.get(position).getOrderTime());
        orderAddress.setText("Szállítási cím: " + orderList.get(position).getUser().getAddress());
        orderItems.setText("Rendelés: " + orderList.get(position).getItems().toString());

        return rowView;
    }
}
