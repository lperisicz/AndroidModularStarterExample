package com.perisic.luka.local.di;

import com.perisic.luka.base.di.qualifiers.DatabaseClass;
import com.perisic.luka.base.di.qualifiers.DatabaseName;
import com.perisic.luka.local.BaseLocalDatabase;
import com.perisic.luka.local.LocalDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
@Module(includes = BaseRoomModule.class)
public abstract class RoomModule {

    @Provides
    @Singleton
    @DatabaseName
    static String provideDatabaseName() {
        return "AndroidModularStarter.db";
    }

    @Provides
    @Singleton
    @DatabaseClass
    static Class<? extends BaseLocalDatabase> provideDatabaseClass() {
        return LocalDatabase.class;
    }

    @Provides
    @Singleton
    static LocalDatabase provideLocalDatabase(BaseLocalDatabase baseLocalDatabase) {
        return (LocalDatabase) baseLocalDatabase;
    }
}