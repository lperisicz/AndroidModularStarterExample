package com.perisic.luka.androidmodularstarterexample.ui;

import android.os.Bundle;

import com.perisic.luka.androidmodularstarterexample.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import retrofit2.Retrofit;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

}