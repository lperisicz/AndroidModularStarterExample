package com.perisic.luka.auth.ui.login;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.perisic.luka.base.di.qualifiers.ViewModelKey;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

import static com.perisic.luka.base.FeatureNavigation.DESTINATION;
import static com.perisic.luka.base.FeatureNavigation.Key;
import static com.perisic.luka.base.FeatureNavigation.Navigator;

/**
 * Created by Luka Perisic on 3.9.2019..
 */
@Module
public abstract class LoginActivityModule {

    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivityInjector();

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel loginViewModel);

    @Singleton
    @Provides
    @IntoMap
    @Key(DESTINATION.LOGIN)
    static Navigator providesRegisterNavigation() {
        return new Navigator() {
            @Override
            public void navigate(Context context) {
                context.startActivity(new Intent(context, LoginActivity.class));
            }
        };
    }

}
