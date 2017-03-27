package com.example.mobsoft.mobilsoftwarelab;


import android.support.v7.app.AppCompatActivity;

import com.example.mobsoft.mobilsoftwarelab.ui.UIModule;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(AppCompatActivity appCompatActivityActivity);

}