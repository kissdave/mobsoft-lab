package com.example.mobsoft.mobilsoftwarelab.ui.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.R;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class SettingsActivity  extends AppCompatActivity implements SettingsScreen {
    @Inject
    SettingsPresenter settingsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        settingsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        settingsPresenter.detachScreen();
    }

    @Override
    public void getSettings(String text) {
        Toast.makeText(this, "Settings updated " + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void save(String text) {
        Toast.makeText(this, "Changes saved " + text, Toast.LENGTH_SHORT).show();
    }
}
