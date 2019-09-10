package com.perisic.luka.auth.ui.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.helper.LiveDataResource;
import com.perisic.luka.remote.data.request.RegisterRequest;
import com.perisic.luka.remote.data.response.RegisterResponse;
import com.perisic.luka.repository.repos.abstraction.AuthRepository;

import javax.inject.Inject;

/**
 * Created by Luka Perisic on 3.9.2019..
 */
class RegisterViewModel extends ViewModel {

    private AuthRepository authRepository;
    private MutableLiveData<BaseData.Status> status = new MutableLiveData<>();
    private LiveDataResource<BaseResponse<RegisterResponse>> registerResponse = new LiveDataResource<>(status::setValue);

    @Inject
    RegisterViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    void register(RegisterRequest registerRequest) {
        registerResponse.addLiveDataSource(
                authRepository.register(registerRequest),
                registerResponse::setValue
        );
    }

    LiveData<BaseData.Status> getStatus() {
        return status;
    }

    LiveData<BaseResponse<RegisterResponse>> getRegisterResponse() {
        return registerResponse;
    }
}
