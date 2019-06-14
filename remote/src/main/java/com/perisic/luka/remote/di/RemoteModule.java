package com.perisic.luka.remote.di;

import com.perisic.luka.base.di.qualifiers.BaseUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Luka Perisic on 14.6.2019..
 */
@Module(includes = BaseRemoteModule.class)
public abstract class RemoteModule {

    @Provides
    @Singleton
    @BaseUrl
    static String provideBaseUrl() {
        return "https://api.ispeaky.app/api/";
    }

}