package com.example.mobsoft.mobilsoftwarelab.ui.orders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.R;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class OrdersActivity extends AppCompatActivity implements OrdersScreen {

    @Inject
    OrdersPresenter ordersPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ordersPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        ordersPresenter.detachScreen();
    }

    @Override
    public void getOrders(String text) {
        Toast.makeText(this, "Orders updated " + text, Toast.LENGTH_SHORT).show();
    }
}
