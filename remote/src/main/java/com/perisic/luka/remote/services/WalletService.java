package com.perisic.luka.remote.services;

import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.response.WalletStatusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.perisic.luka.remote.config.WalletServiceConfig.ROUTE_STATUS;

/**S
 * Created by Luka Perisic on 17.6.2019..
 */
public interface WalletService {

    @GET(ROUTE_STATUS)
    Call<BaseResponse<WalletStatusResponse>> getWalletStatus();

}