package com.example.mobsoft.mobilsoftwarelab.ui.settings;

import android.util.Log;

import com.example.mobsoft.mobilsoftwarelab.interactor.user.UserInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.user.events.GetSettingsEvent;
import com.example.mobsoft.mobilsoftwarelab.interactor.user.events.SaveSettingsEvent;
import com.example.mobsoft.mobilsoftwarelab.model.User;
import com.example.mobsoft.mobilsoftwarelab.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobilsoftwarelab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class SettingsPresenter extends Presenter<SettingsScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public SettingsPresenter() {
    }

    @Override
    public void attachScreen(SettingsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getSettngs() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.getSettings();
            }
        });
    }

    public void saveSettings(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.saveSettings(user);
            }
        });
    }

    public void onEventMainThread(GetSettingsEvent event) {
        Log.d("Settings presenter", "getSettngs");
        if(event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if(screen != null) {
                screen.showMessage("Error: " + event.getThrowable().getMessage());
            }
            Log.e("Networking", "Error getting settings", event.getThrowable());
        } else {
            if(screen != null) {
                screen.displaySettings(event.getUser());
            }
        }
    }

    public void onEventMainThread(SaveSettingsEvent event) {
        Log.d("Settings presenter", "getSettngs");
        if(event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if(screen != null) {
                screen.showMessage("Error: " + event.getThrowable().getMessage());
            }
            Log.e("Networking", "Error getting settings", event.getThrowable());
        } else {
            if(screen != null) {
                screen.showMessage("Settings saved.");
            }
        }
    }
}
