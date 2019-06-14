package com.perisic.luka.androidmodularstarterexample.di.module;

import android.content.Context;

import com.perisic.luka.androidmodularstarterexample.AndroidModularStarterApp;
import com.perisic.luka.base.di.qualifiers.ApplicationContext;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Module
public abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract Context provideContext(AndroidModularStarterApp androidModularStarterApp);

}