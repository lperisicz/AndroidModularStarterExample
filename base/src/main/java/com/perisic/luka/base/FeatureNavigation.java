package com.perisic.luka.base;

import android.content.Context;
import android.content.Intent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.MapKey;

/**
 * Created by Luka Perisic on 3.9.2019..
 */
@Singleton
public class FeatureNavigation {

    private Map<DESTINATION, Provider<Navigator>> navigationProviders;

    @Inject
    public FeatureNavigation(Map<DESTINATION, Provider<Navigator>> navigationProviders) {
        this.navigationProviders = navigationProviders;
    }

    public void navigate(Context context, DESTINATION destination){
        Provider<Navigator> provider = navigationProviders.get(destination);
        if (provider != null) {
            provider.get().navigate(context);
        } else {
            NavigationException.throwException();
        }
    }

    public void navigate(Context context, Intent intent, DESTINATION destination){
        Provider<Navigator> provider = navigationProviders.get(destination);
        if (provider != null) {
            provider.get().navigate(context, intent);
        } else {
            NavigationException.throwException();
        }
    }

    public enum DESTINATION {
        LOGIN,
        REGISTER,
        POST_LIST,
        POST_CREATE,
        POST_SINGLE
    }

    public interface Navigator {

        default void navigate(Context context) {
        }

        default void navigate(Context context, Intent intent) {
        }

    }

    public static class NavigationException extends RuntimeException {

        static final String EXCEPTION = "Requested destination provider is not defined.";

        static void throwException() {throw new NavigationException(EXCEPTION);}

        NavigationException(String message) {
            super(message);
        }
    }

    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @MapKey
    public @interface Key {

        DESTINATION value();

    }

}
