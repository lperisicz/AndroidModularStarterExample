package com.perisic.luka.repository.di;

import com.perisic.luka.local.di.RoomModule;
import com.perisic.luka.remote.di.ServiceModule;
import com.perisic.luka.repository.repos.abstraction.WalletRepository;
import com.perisic.luka.repository.repos.implementation.WalletRepositoryImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Luka Perisic on 17.6.2019..
 */
@Module(includes = {BaseRepositoryModule.class, ServiceModule.class, RoomModule.class})
public abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract WalletRepository bindsWalletRepository(WalletRepositoryImpl walletRepository);

}