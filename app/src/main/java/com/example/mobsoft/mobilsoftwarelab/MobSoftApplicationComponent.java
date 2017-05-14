package com.example.mobsoft.mobilsoftwarelab;


import android.support.v7.app.AppCompatActivity;

import com.example.mobsoft.mobilsoftwarelab.interactor.InteractorModule;
import com.example.mobsoft.mobilsoftwarelab.interactor.cart.CartInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.order.OrderInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.product.ProductsInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.user.UserInteractor;
import com.example.mobsoft.mobilsoftwarelab.network.NetworkModule;
import com.example.mobsoft.mobilsoftwarelab.repository.RepositoryModule;
import com.example.mobsoft.mobilsoftwarelab.ui.UIModule;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.settings.SettingsActivity;
import com.example.mobsoft.mobilsoftwarelab.ui.settings.SettingsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainActivity mainActivity);

    void inject(CartActivity cartActivity);

    void inject(OrdersActivity ordersActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(MainPresenter mainPresenter);

    void inject(CartPresenter cartPresenter);

    void inject(OrdersPresenter ordersPresenter);

    void inject(SettingsPresenter settingsPresenter);

    void inject(ProductsInteractor productsInteractor);

    void inject(UserInteractor userInteractor);

    void inject(OrderInteractor orderInteractor);

    void inject(CartInteractor cartInteractor);
}