package com.perisic.luka.repository.repos.abstraction;

import androidx.lifecycle.LiveData;

import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.response.WalletStatusResponse;
import com.perisic.luka.repository.repos.BaseRepository;

/**
 * Created by Luka Perisic on 17.6.2019..
 */
public interface WalletRepository extends BaseRepository {

    LiveData<BaseResponse<WalletStatusResponse>> getWalletStatus();

}
