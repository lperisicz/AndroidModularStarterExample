package com.perisic.luka.repository.di;

import com.perisic.luka.local.di.RoomModule;
import com.perisic.luka.remote.di.ServiceModule;
import com.perisic.luka.repository.repos.abstraction.PostRepository;
import com.perisic.luka.repository.repos.implementation.PostRepositoryImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Luka Perisic on 17.6.2019..
 */
@Module(includes = {BaseRepositoryModule.class, ServiceModule.class, RoomModule.class})
public abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract PostRepository bindsPostRepository(PostRepositoryImpl postRepository);

}