package com.perisic.luka.auth.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;

import com.perisic.luka.auth.R;
import com.perisic.luka.base.FeatureNavigation;
import com.perisic.luka.base.viewModel.ViewModelFactory;
import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.request.LoginRequest;
import com.perisic.luka.remote.data.response.LoginResponse;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import static com.perisic.luka.base.FeatureNavigation.*;

public class LoginActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;
    @Inject
    FeatureNavigation featureNavigation;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        loginViewModel.getStatus().observe(this, this::handleStatus);
        loginViewModel.getLoginResponse().observe(this, this::handleResponse);
        findViewById(R.id.button_login).setOnClickListener(v -> loginViewModel.login(
                new LoginRequest(
                        ((TextView) findViewById(R.id.edit_text_email)).getText().toString(),
                        ((TextView) findViewById(R.id.edit_text_password)).getText().toString()
                )
        ));
        findViewById(R.id.text_view_register).setOnClickListener(v -> featureNavigation.navigate(this, DESTINATION.REGISTER));
    }

    private void handleStatus(BaseData.Status status) {
        if (status != null) {
            switch (status) {
                case DONE: break;
                case ERROR:
                    Toast.makeText(this, status.name() + " try again", Toast.LENGTH_SHORT).show();
                    break;
                case LOADING: break;
                default: break;
            }
        }
    }

    private void handleResponse(BaseResponse<LoginResponse> loginResponse) {
        if(loginResponse != null && loginResponse.getData() != null && loginResponse.getData().getToken() != null) {
            featureNavigation.navigate(this, DESTINATION.POST_LIST);
        }
    }
}
