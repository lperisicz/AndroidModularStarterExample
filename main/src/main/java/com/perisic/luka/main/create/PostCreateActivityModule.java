package com.perisic.luka.main.create;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.perisic.luka.base.FeatureNavigation;
import com.perisic.luka.base.di.qualifiers.ViewModelKey;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

import static com.perisic.luka.base.FeatureNavigation.*;
import static com.perisic.luka.base.FeatureNavigation.DESTINATION.*;

/**
 * Created by Luka Perisic on 4.9.2019..
 */
@Module
public abstract class PostCreateActivityModule {

    @ContributesAndroidInjector
    abstract PostCreateActivity contributesPostCreateActivityInjector();

    @Binds
    @IntoMap
    @ViewModelKey(PostCreateViewModel.class)
    abstract ViewModel bindPostCreateViewModel(PostCreateViewModel postCreateViewModel);

    @Singleton
    @Provides
    @IntoMap
    @Key(POST_CREATE)
    static Navigator providesPostCreateNavigation() {
        return new Navigator() {
            @Override
            public void navigate(Context context) {
                context.startActivity(new Intent(context, PostCreateActivity.class));
            }
        };
    }

}
