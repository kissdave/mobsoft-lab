package com.example.mobsoft.mobilsoftwarelab.ui.main;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.R;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.settings.SettingsActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        mainPresenter.attachScreen(this);
        this.getProducts("Updating products...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
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
            Toast.makeText(this, "You are on this page already...", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cart) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
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
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayProducts(List<Product> products) {
        Toast.makeText(this, "Products added", Toast.LENGTH_SHORT).show();
        final ProductsArrayAdapterMain adapter = new ProductsArrayAdapterMain(this, products);
        ((ListView)this.findViewById(R.id.productsListView)).setAdapter(adapter);
    }

    @Override
    public void getProducts(String text) {
        mainPresenter.getProducts();
    }

    @Override
    public void addProductToCart(Product product) {
        mainPresenter.addProductToCart(product);
        Toast.makeText(this, "Product added to cart", Toast.LENGTH_SHORT).show();
    }
}
