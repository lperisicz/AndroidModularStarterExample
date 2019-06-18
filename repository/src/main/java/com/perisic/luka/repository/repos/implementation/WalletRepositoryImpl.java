package com.perisic.luka.repository.repos.implementation;

import androidx.lifecycle.LiveData;

import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.response.WalletStatusResponse;
import com.perisic.luka.remote.services.WalletService;
import com.perisic.luka.repository.repos.abstraction.WalletRepository;

import javax.inject.Inject;

/**
 * Created by Luka Perisic on 17.6.2019..
 */
public class WalletRepositoryImpl implements WalletRepository {

    private WalletService walletService;

    @Inject
    WalletRepositoryImpl(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public LiveData<BaseResponse<WalletStatusResponse>> getWalletStatus() {
        return executeCall(walletService.getWalletStatus());
    }

}