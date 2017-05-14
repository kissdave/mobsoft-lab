package com.example.mobsoft.mobilsoftwarelab.repository;

import com.example.mobsoft.mobilsoftwarelab.repository.MemoryRepository;
import com.example.mobsoft.mobilsoftwarelab.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dkiss on 2017. 05. 07..
 */
@Module
public class TestRepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}
