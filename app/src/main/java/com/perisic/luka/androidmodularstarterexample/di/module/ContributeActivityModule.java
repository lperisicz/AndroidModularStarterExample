package com.perisic.luka.androidmodularstarterexample.di.module;

import com.perisic.luka.androidmodularstarterexample.ui.MainActivityModule;

import dagger.Module;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Module(includes = {MainActivityModule.class})
public abstract class ContributeActivityModule {
}
