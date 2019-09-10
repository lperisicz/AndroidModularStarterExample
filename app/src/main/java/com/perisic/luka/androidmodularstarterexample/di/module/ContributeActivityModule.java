package com.perisic.luka.androidmodularstarterexample.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.perisic.luka.androidmodularstarterexample.ui.MainActivityModule;
import com.perisic.luka.auth.ui.login.LoginActivityModule;
import com.perisic.luka.auth.ui.register.RegisterActivityModule;
import com.perisic.luka.base.viewModel.ViewModelFactory;
import com.perisic.luka.main.create.PostCreateActivityModule;
import com.perisic.luka.main.list.PostListActivityModule;
import com.perisic.luka.main.single.PostSingleActivityModule;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Module(includes = {
        MainActivityModule.class,
        LoginActivityModule.class,
        RegisterActivityModule.class,
        PostListActivityModule.class,
        PostCreateActivityModule.class,
        PostSingleActivityModule.class,
})
public abstract class ContributeActivityModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
