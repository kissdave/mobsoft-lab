package com.example.mobsoft.mobilsoftwarelab;

import com.example.mobsoft.mobilsoftwarelab.interactor.InteractorModule;
import com.example.mobsoft.mobilsoftwarelab.mock.MockNetworkModule;
import com.example.mobsoft.mobilsoftwarelab.repository.TestRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dkiss on 2017. 05. 07..
 */
@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
