package com.example.mobsoft.mobilsoftwarelab.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobsoft.mobilsoftwarelab.R;
import com.example.mobsoft.mobilsoftwarelab.model.Product;

import java.util.List;

/**
 * Created by dkiss on 2017. 05. 15..
 */

public class ProductsArrayAdapterMain extends ArrayAdapter<Product> {
    private final Context context;
    private final List<Product> products;

    public ProductsArrayAdapterMain(Context context, List<Product> products) {
        super(context, -1, products);
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView name = (TextView) rowView.findViewById(R.id.product_name);
        TextView desciption = (TextView) rowView.findViewById(R.id.product_description);
        Button addToCart = (Button) rowView.findViewById(R.id.addToCartButton);

        name.setText(products.get(position).getName());
        desciption.setText(products.get(position).getDescription());
        addToCart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof MainActivity) {
                    ((MainActivity)context).addProductToCart(products.get(position));
                }
            }
        });

        return rowView;

    }

    @Override
    public int getCount() {
        return products.size();
    }
}
