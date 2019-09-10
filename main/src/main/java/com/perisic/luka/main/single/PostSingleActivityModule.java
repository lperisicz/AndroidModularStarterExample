package com.perisic.luka.main.single;

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
 * Created by Luka Perisic on 4.9.2019..
 */
@Module
public abstract class PostSingleActivityModule {

    @ContributesAndroidInjector
    abstract PostSingleActivity contributesPostSingleActivityInjector();

    @Binds
    @IntoMap
    @ViewModelKey(PostSingleViewModel.class)
    abstract ViewModel bindPostSingleViewModel(PostSingleViewModel postSingleViewModel);

    @Singleton
    @Provides
    @IntoMap
    @Key(DESTINATION.POST_SINGLE)
    static Navigator providePostSingleNavigation() {
        return new Navigator() {
            @Override
            public void navigate(Context context, Intent intent) {
                if (intent.getExtras() != null) {
                    context.startActivity(new Intent(context, PostSingleActivity.class).putExtras(intent.getExtras()));
                }
            }
        };
    }
}
