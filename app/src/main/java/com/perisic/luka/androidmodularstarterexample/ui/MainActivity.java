package com.perisic.luka.androidmodularstarterexample.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;
import com.perisic.luka.androidmodularstarterexample.R;
import com.perisic.luka.base.viewModel.ViewModelFactory;
import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.response.WalletStatusResponse;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        mainViewModel.getWalletStatusResponse().observe(this, this::handleResponse);
        mainViewModel.getStatus().observe(this, this::handleStatus);
        findViewById(R.id.button).setOnClickListener(v -> mainViewModel.fetchWalletStatus());
        ((SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout)).setOnRefreshListener(() -> mainViewModel.fetchWalletStatus());
        ((Toolbar)findViewById(R.id.toolbar)).setTitle("AndroidModularStarterExample");
    }

    private void handleStatus(BaseData.Status status) {
        if (status != null) {
            ((TextView) findViewById(R.id.text_view_call_status)).setText(status.name());
            ((ProgressBar)findViewById(R.id.progress_bar)).setVisibility(status.equals(BaseData.Status.LOADING) ? View.VISIBLE : View.INVISIBLE);
            ((SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout)).setRefreshing(status.equals(BaseData.Status.LOADING));
            if(status.equals(BaseData.Status.ERROR)) {
                Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), status.name(), Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void handleResponse(BaseResponse<WalletStatusResponse> walletStatusResponseBaseResponse) {
        if (walletStatusResponseBaseResponse.getStatus() != null && walletStatusResponseBaseResponse.getStatus().equals(BaseData.Status.DONE)) {
            ((TextView) findViewById(R.id.text_view_status))
                    .setText("Status: " + walletStatusResponseBaseResponse.getData().getDuration());
        }
    }

}