package com.perisic.luka.androidmodularstarterexample;

import com.perisic.luka.androidmodularstarterexample.di.component.AppComponent;
import com.perisic.luka.androidmodularstarterexample.di.component.DaggerAppComponent;
import com.perisic.luka.base.di.helper.TokenModelProvider;
import com.perisic.luka.local.dao.TokenModelDao;
import com.perisic.luka.local.data.TokenModel;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by Luka Perisic on 13.6.2019..
 */
public class AndroidModularStarterApp extends DaggerApplication {

    @Inject
    TokenModelDao tokenModelDao;
    @Inject
    TokenModelProvider tokenModelProvider;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        initDagger();
        super.onCreate();
        fetchSavedToken();
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

    private void fetchSavedToken() {
        TokenModel tokenModel = tokenModelDao.getTokenModel();
        if (tokenModel != null) {
            tokenModelProvider.setToken(tokenModel.getToken());
            tokenModelProvider.setRefreshToken(tokenModel.getRefreshToken());
        }
    }

}