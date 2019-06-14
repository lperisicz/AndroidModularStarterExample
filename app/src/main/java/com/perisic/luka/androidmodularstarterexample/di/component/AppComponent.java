package com.perisic.luka.androidmodularstarterexample.di.component;

import com.perisic.luka.androidmodularstarterexample.AndroidModularStarterApp;
import com.perisic.luka.androidmodularstarterexample.di.module.AppModule;
import com.perisic.luka.androidmodularstarterexample.di.module.ContributeActivityModule;
import com.perisic.luka.remote.di.RemoteModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ContributeActivityModule.class,
        RemoteModule.class
})
public interface AppComponent extends AndroidInjector<AndroidModularStarterApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(AndroidModularStarterApp androidModularStarterApp);

        AppComponent build();

    }

}
