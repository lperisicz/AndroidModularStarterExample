package com.perisic.luka.androidmodularstarterexample.ui;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivityInjector();

}