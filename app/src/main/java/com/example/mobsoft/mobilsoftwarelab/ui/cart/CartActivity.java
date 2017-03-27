package com.example.mobsoft.mobilsoftwarelab.ui.cart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.R;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class CartActivity extends AppCompatActivity implements CartScreen {

    @Inject
    CartPresenter cartPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cartPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        cartPresenter.detachScreen();
    }

    @Override
    public void sendOrder(String text) {
        Toast.makeText(this, "Order sent: " + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void discardOrder(String text) {
        Toast.makeText(this, "Order discarded: " + text, Toast.LENGTH_SHORT).show();
    }

}
