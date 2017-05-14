package com.example.mobsoft.mobilsoftwarelab.test;

import com.example.mobsoft.mobilsoftwarelab.BuildConfig;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartScreen;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainScreen;
import com.example.mobsoft.mobilsoftwarelab.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.mobsoft.mobilsoftwarelab.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by dkiss on 2017. 05. 14..
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CartTest  {
    private CartPresenter cartPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        cartPresenter = new CartPresenter();
    }

    @Test
    public void testCart() {
        CartScreen cartScreen = mock(CartScreen.class);
        cartPresenter.attachScreen(cartScreen);
        cartPresenter.getCartItems();

        ArgumentCaptor<Product> productsCaptor = ArgumentCaptor.forClass(Product.class);
        verify(cartScreen, times(2)).displayProduct(productsCaptor.capture());

        List<Product> capturedProducts = productsCaptor.getAllValues();
        assertEquals("Hawaii pizza", capturedProducts.get(0).getName());
        assertEquals("Szalámis pizza", capturedProducts.get(1).getName());
    }

    @After
    public void tearDown() {
        cartPresenter.detachScreen();
    }
}
