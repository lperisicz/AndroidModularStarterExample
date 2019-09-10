package com.perisic.luka.remote.di;

import com.perisic.luka.remote.services.PostService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Luka Perisic on 14.6.2019..
 */
@Module(includes = {BaseServiceModule.class, RemoteModule.class})
public abstract class ServiceModule {

    @Provides
    @Singleton
    static PostService providesWalletService(Retrofit retrofit) {
        return retrofit.create(PostService.class);
    }

}
