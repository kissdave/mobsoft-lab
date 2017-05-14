package com.example.mobsoft.mobilsoftwarelab.test;

import com.example.mobsoft.mobilsoftwarelab.BuildConfig;
import com.example.mobsoft.mobilsoftwarelab.model.Product;
import com.example.mobsoft.mobilsoftwarelab.model.User;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.cart.CartScreen;
import com.example.mobsoft.mobilsoftwarelab.ui.settings.SettingsPresenter;
import com.example.mobsoft.mobilsoftwarelab.ui.settings.SettingsScreen;
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
public class SettingsTest  {
    private SettingsPresenter settingsPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        settingsPresenter = new SettingsPresenter();
    }

    @Test
    public void testUser() {
        SettingsScreen settingsScreen = mock(SettingsScreen.class);
        settingsPresenter.attachScreen(settingsScreen);
        settingsPresenter.getSettngs();

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(settingsScreen, times(1)).displaySettings(userCaptor.capture());

        List<User> capturedUser = userCaptor.getAllValues();
        assertEquals("Kiss Dávid", capturedUser.get(0).getName());
    }

    @After
    public void tearDown() {
        settingsPresenter.detachScreen();
    }
}
