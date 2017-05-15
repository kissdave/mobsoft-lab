package com.example.mobsoft.mobilsoftwarelab.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.R;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.settings.SettingsActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class CartActivity extends AppCompatActivity implements CartScreen, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    CartPresenter cartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        MobSoftApplication.injector.inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cartPresenter.attachScreen(this);
        this.getCartItems("Getting items");
    }

    @Override
    protected void onStop() {
        super.onStop();
        cartPresenter.detachScreen();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_pizza) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_orders) {
            Intent intent = new Intent(this, OrdersActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void getCartItems(String text) {
        cartPresenter.getCartItems();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendOrder(String text) {
        Toast.makeText(this, "Order sent: " + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayProducts(List<Product> products) {
        int sum = calculateSum(products);
        TextView orderInfo = (TextView)findViewById(R.id.order_info);
        orderInfo.setText("A rendelés összege: " + sum + " Ft");

        Button submitOrder = (Button)findViewById(R.id.order_btn);
        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartPresenter.sendOrder();
            }
        });

        final ProductsArrayAdapterCart adapter = new ProductsArrayAdapterCart(this, products);
        ((ListView)this.findViewById(R.id.productsListView)).setAdapter(adapter);
        Toast.makeText(this, "List updated", Toast.LENGTH_SHORT).show();
    }

    private int calculateSum(List<Product> products) {
        int sum = 0;
        for(Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }
}
