package com.example.mobsoft.mobilsoftwarelab.ui;

import android.content.Context;

import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.settings.SettingsPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public CartPresenter cartPresenter() {
        return new CartPresenter();
    }

    @Provides
    @Singleton
    public OrdersPresenter ordersPresenter() {
        return new OrdersPresenter();
    }

    @Provides
    @Singleton
    public SettingsPresenter settingsPresenter() {
        return new SettingsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}