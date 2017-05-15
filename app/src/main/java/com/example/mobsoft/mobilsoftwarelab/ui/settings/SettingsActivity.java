package com.example.mobsoft.mobilsoftwarelab.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.R;
import com.example.mobsoft.mobilsoftwarelab.model.User;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class SettingsActivity extends AppCompatActivity implements SettingsScreen, NavigationView.OnNavigationItemSelectedListener {

    private Tracker mTracker;

    @Inject
    SettingsPresenter settingsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        MobSoftApplication.injector.inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MobSoftApplication application = (MobSoftApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        settingsPresenter.attachScreen(this);

        mTracker.setScreenName("Image~MainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        this.getSettings("Getting settings...");

        Button saveBtn = (Button) findViewById(R.id.setting_save_btn);
        saveBtn.setOnClickListener(new SaveButtonListener(this));

    }

    @Override
    protected void onStop() {
        super.onStop();
        settingsPresenter.detachScreen();
    }

    @Override
    public void getSettings(String text) {
        settingsPresenter.getSettngs();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void save(String text) {
        EditText settingsName = (EditText) this.findViewById(R.id.settings_name);
        EditText settingsMail = (EditText) this.findViewById(R.id.settings_mail);
        EditText settingsPhone = (EditText) this.findViewById(R.id.settings_phone);
        EditText settingsAddresse = (EditText) this.findViewById(R.id.settings_address);

        settingsPresenter.saveSettings(new User(1L,
                settingsName.getText().toString(),
                settingsMail.getText().toString(),
                settingsPhone.getText().toString(),
                settingsAddresse.getText().toString()));

        Toast.makeText(this, "Changes saved " + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displaySettings(User user) {
        EditText settingsName = (EditText) this.findViewById(R.id.settings_name);
        EditText settingsMail = (EditText) this.findViewById(R.id.settings_mail);
        EditText settingsPhone = (EditText) this.findViewById(R.id.settings_phone);
        EditText settingsAddresse = (EditText) this.findViewById(R.id.settings_address);

        settingsName.setText(user.getName());
        settingsMail.setText(user.getEmail());
        settingsPhone.setText(user.getMobile());
        settingsAddresse.setText(user.getAddress());

        Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_orders) {
            Intent intent = new Intent(this, OrdersActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            Toast.makeText(this, "You are on this page already...", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
