package com.perisic.luka.auth.ui.register;

import android.os.Bundle;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;

import com.perisic.luka.auth.R;
import com.perisic.luka.base.FeatureNavigation;
import com.perisic.luka.base.viewModel.ViewModelFactory;
import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.request.RegisterRequest;
import com.perisic.luka.remote.data.response.RegisterResponse;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import static com.perisic.luka.base.FeatureNavigation.*;

public class RegisterActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;
    @Inject
    FeatureNavigation featureNavigation;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerViewModel = ViewModelProviders.of(this, viewModelFactory).get(RegisterViewModel.class);
        registerViewModel.getStatus().observe(this, this::handleStatus);
        registerViewModel.getRegisterResponse().observe(this, this::handleResponse);
        findViewById(R.id.text_view_login).setOnClickListener(v -> featureNavigation.navigate(this, DESTINATION.LOGIN));
        findViewById(R.id.button_register).setOnClickListener(v -> registerViewModel.register(
                new RegisterRequest(
                        ((TextView) findViewById(R.id.edit_text_name)).getText().toString(),
                        ((TextView) findViewById(R.id.edit_text_email)).getText().toString(),
                        ((TextView) findViewById(R.id.edit_text_password)).getText().toString(),
                        ((TextView) findViewById(R.id.edit_text_confirm_password)).getText().toString()
                )
        ));

    }

    private void handleStatus(BaseData.Status status) {
        if (status != null) {
            switch (status) {
                case DONE: break;
                case ERROR: break;
                case LOADING: break;
                default: break;
            }
        }
    }

    private void handleResponse(BaseResponse<RegisterResponse> registerResponse) {
        if(registerResponse != null && registerResponse.getData() != null && registerResponse.getData().getToken() != null) {
            featureNavigation.navigate(this, DESTINATION.POST_LIST);
        }
    }
}
