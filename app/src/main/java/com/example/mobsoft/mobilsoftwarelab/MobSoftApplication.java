package com.example.mobsoft.mobilsoftwarelab;

import android.app.Application;

import com.example.mobsoft.mobilsoftwarelab.repository.Repository;
import com.example.mobsoft.mobilsoftwarelab.ui.UIModule;

import javax.inject.Inject;


public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}