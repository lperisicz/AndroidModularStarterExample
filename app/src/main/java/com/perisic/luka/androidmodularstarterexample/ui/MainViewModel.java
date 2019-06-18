package com.perisic.luka.androidmodularstarterexample.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.helper.LiveDataResource;
import com.perisic.luka.remote.data.response.WalletStatusResponse;
import com.perisic.luka.repository.repos.abstraction.WalletRepository;

import javax.inject.Inject;

/**
 * Created by Luka Perisic on 18.6.2019..
 */
class MainViewModel extends ViewModel {

    private WalletRepository walletRepository;
    private MutableLiveData<BaseData.Status> status = new MutableLiveData<>();
    private LiveDataResource<BaseResponse<WalletStatusResponse>> walletStatusResponse = new LiveDataResource<>(status::setValue);

    @Inject
    MainViewModel(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    void fetchWalletStatus() {
        walletStatusResponse.addLiveDataSource(
                walletRepository.getWalletStatus(),
                walletStatusResponse::setValue
        );
    }

    LiveDataResource<BaseResponse<WalletStatusResponse>> getWalletStatusResponse() {
        return walletStatusResponse;
    }

    LiveData<BaseData.Status> getStatus() {
        return status;
    }
}