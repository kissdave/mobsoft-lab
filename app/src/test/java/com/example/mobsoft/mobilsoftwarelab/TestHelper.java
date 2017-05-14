package com.example.mobsoft.mobilsoftwarelab;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by dkiss on 2017. 05. 07..
 */

public class TestHelper {
public static void setTestInjector() {
    ShadowLog.stream = System.out;
    MobSoftApplication application = (MobSoftApplication) RuntimeEnvironment.application;
    MobSoftApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
    application.setInjector(injector);
}
}
