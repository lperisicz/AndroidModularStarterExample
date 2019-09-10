package com.perisic.luka.auth.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.helper.LiveDataResource;
import com.perisic.luka.remote.data.request.LoginRequest;
import com.perisic.luka.remote.data.response.LoginResponse;
import com.perisic.luka.repository.repos.abstraction.AuthRepository;

import javax.inject.Inject;

/**
 * Created by Luka Perisic on 3.9.2019..
 */
class LoginViewModel extends ViewModel {

    private AuthRepository authRepository;
    private MutableLiveData<BaseData.Status> status = new MutableLiveData<>();
    private LiveDataResource<BaseResponse<LoginResponse>> loginResponse = new LiveDataResource<>(status::setValue);

    @Inject
    LoginViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    void login(LoginRequest loginRequest) {
        loginResponse.addLiveDataSource(
                authRepository.login(loginRequest),
                loginResponse::setValue
        );
    }

    LiveData<BaseData.Status> getStatus() {
        return status;
    }

    LiveData<BaseResponse<LoginResponse>> getLoginResponse() {
        return loginResponse;
    }
}