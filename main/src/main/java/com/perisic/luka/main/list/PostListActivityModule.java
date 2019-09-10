package com.perisic.luka.main.list;

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

/**
 * Created by Luka Perisic on 3.9.2019..
 */
@Module
public abstract class PostListActivityModule {

    @ContributesAndroidInjector
    abstract PostListActivity contributePostListActivityInjector();

    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel.class)
    abstract ViewModel bindPostListViewModel(PostListViewModel postListViewModel);

    @Singleton
    @Provides
    @IntoMap
    @Key(DESTINATION.POST_LIST)
    static Navigator providesPostListNavigation() {
        return new Navigator() {
            @Override
            public void navigate(Context context) {
                context.startActivity(new Intent(context, PostListActivity.class));
            }
        };
    }

}
