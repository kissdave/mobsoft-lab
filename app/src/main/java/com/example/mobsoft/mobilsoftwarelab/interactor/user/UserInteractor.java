package com.example.mobsoft.mobilsoftwarelab.interactor.user;

import com.example.mobsoft.mobilsoftwarelab.MobSoftApplication;
import com.example.mobsoft.mobilsoftwarelab.interactor.user.events.GetSettingsEvent;
import com.example.mobsoft.mobilsoftwarelab.interactor.user.events.SaveSettingsEvent;
import com.example.mobsoft.mobilsoftwarelab.model.User;
import com.example.mobsoft.mobilsoftwarelab.repository.Repository;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by dkiss on 2017. 04. 24..
 */

public class UserInteractor {


    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getSettings() {
        GetSettingsEvent event = new GetSettingsEvent();
        try {
            User user = repository.getSettings();
            event.setUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveSettings(User user) {
        SaveSettingsEvent event = new SaveSettingsEvent();
        event.setUser(user);
        try {
            repository.saveSettings(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
