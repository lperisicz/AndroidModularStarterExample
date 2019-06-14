package com.perisic.luka.androidmodularstarterexample;

import com.perisic.luka.androidmodularstarterexample.di.component.AppComponent;
import com.perisic.luka.androidmodularstarterexample.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
public class AndroidModularStarterApp extends DaggerApplication {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        initDagger();
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return appComponent;
    }

    private void initDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
    }

}
