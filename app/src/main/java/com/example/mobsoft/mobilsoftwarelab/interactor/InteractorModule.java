package com.example.mobsoft.mobilsoftwarelab.interactor;

import com.example.mobsoft.mobilsoftwarelab.interactor.cart.CartInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.order.OrderInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.product.ProductsInteractor;
import com.example.mobsoft.mobilsoftwarelab.interactor.user.UserInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dkiss on 2017. 04. 24..
 */

@Module
public class InteractorModule {

    @Provides
    public CartInteractor cartInteractor() {
        return new CartInteractor();
    }

    @Provides
    public OrderInteractor orderInteractor() {
        return new OrderInteractor();
    }

    @Provides
    public ProductsInteractor productsInteractor() {
        return new ProductsInteractor();
    }

    @Provides
    public UserInteractor userInteractor() {
        return new UserInteractor();
    }
}
