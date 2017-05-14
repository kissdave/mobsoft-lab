package com.example.mobsoft.mobilsoftwarelab;

import android.content.Context;

import com.example.mobsoft.mobilsoftwarelab.ui.UIModule;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.settings.SettingsPresenter;
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

    public TestModule(Context context) {
        this.uiModule = new UIModule(context);
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
    public CartPresenter cartPresenter() { return uiModule.cartPresenter(); }

    @Provides
    public OrdersPresenter ordersPresenter() { return uiModule.ordersPresenter(); }

    @Provides
    public SettingsPresenter settingsPresenter() { return uiModule.settingsPresenter(); }

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
