package com.example.mobsoft.mobilsoftwarelab.test;

import com.example.mobsoft.mobilsoftwarelab.BuildConfig;
import com.example.mobsoft.mobilsoftwarelab.model.Order;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.main.MainScreen;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.orders.OrdersScreen;
import com.example.mobsoft.mobilsoftwarelab.utils.RobolectricDaggerTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.Date;
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
public class OrderTest  {
    private OrdersPresenter ordersPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        ordersPresenter = new OrdersPresenter();
    }

    @Test
    public void testOrder() {
        OrdersScreen ordersScreen = mock(OrdersScreen.class);
        ordersPresenter.attachScreen(ordersScreen);
        ordersPresenter.getOrders();

        ArgumentCaptor<List<Order>> productsCaptor = ArgumentCaptor.forClass((Class) List.class);
        verify(ordersScreen, times(1)).displayOrders(productsCaptor.capture());

        List<Order> capturedProducts = productsCaptor.getValue();
        assertEquals(new Date(2017, 4, 23), capturedProducts.get(0).getOrderTime());
    }

    @After
    public void tearDown() {
        ordersPresenter.detachScreen();
    }
}
