package com.example.mobsoft.mobilsoftwarelab;

import android.content.Context;

import com.example.mobsoft.mobilsoftwarelab.ui.UIModule;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainPresenter;
import com.example.mobsoft.mobilsoftwarelab.utils.UiExecutor;

import java.util.concurrent.Executor;

import dagger.Module;
import de.greenrobot.event.EventBus;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by dkiss on 2017. 05. 07..
 */
@Module
public class TestModule {
    private final UIModule uiModule;

    public TestModule(UIModule uiModule) {
        this.uiModule = uiModule;
    }

    @Provides
    public Context provideContext() {
        return uiModule.provideContext();
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return uiModule.provideMainPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }
}
