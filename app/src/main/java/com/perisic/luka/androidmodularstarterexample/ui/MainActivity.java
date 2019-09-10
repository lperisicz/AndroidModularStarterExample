package com.perisic.luka.androidmodularstarterexample.ui;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import com.perisic.luka.androidmodularstarterexample.R;
import com.perisic.luka.base.FeatureNavigation;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    FeatureNavigation featureNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(v -> featureNavigation.navigate(this, FeatureNavigation.DESTINATION.LOGIN));
        ((Toolbar) findViewById(R.id.toolbar)).setTitle("AndroidModularStarterExample");
    }

}