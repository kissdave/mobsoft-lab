package com.example.mobsoft.mobilsoftwarelab.ui.settings;

import com.example.mobsoft.mobilsoftwarelab.interactor.user.UserInteractor;
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
}
