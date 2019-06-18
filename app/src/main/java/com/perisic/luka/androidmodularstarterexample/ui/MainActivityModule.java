package com.perisic.luka.androidmodularstarterexample.ui;

import androidx.lifecycle.ViewModel;

import com.perisic.luka.base.di.qualifiers.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivityInjector();

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

}