package com.perisic.luka.androidmodularstarterexample.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.perisic.luka.androidmodularstarterexample.ui.MainActivityModule;
import com.perisic.luka.base.viewModel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Module(includes = {MainActivityModule.class})
public abstract class ContributeActivityModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
