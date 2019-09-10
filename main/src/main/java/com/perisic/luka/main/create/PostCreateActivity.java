package com.perisic.luka.main.create;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.perisic.luka.base.viewModel.ViewModelFactory;
import com.perisic.luka.main.R;
import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.request.PostCreateRequest;
import com.perisic.luka.remote.data.response.Post;
import com.perisic.luka.ui.SensorActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import hr.gauss.camera.CameraActivity;

public class PostCreateActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;
    private PostCreateViewModel postCreateViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_create);

        postCreateViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostCreateViewModel.class);
        postCreateViewModel.getStatus().observe(this, this::handleStatus);
        postCreateViewModel.getPostCreateResponse().observe(this, this::handlePostCreateResponse);

        findViewById(R.id.edit_text_url).setOnClickListener(v -> startActivityForResult(new Intent(this, CameraActivity.class), 122));
        findViewById(R.id.edit_text_color).setOnClickListener(v -> startActivityForResult(new Intent(this, SensorActivity.class), 123));
        findViewById(R.id.button_add_post).setOnClickListener(v -> postCreateViewModel.createPost(new PostCreateRequest(
                ((TextView)findViewById(R.id.edit_text_title)).getText().toString(),
                ((TextView)findViewById(R.id.edit_text_url)).getText().toString(),
                ((TextView)findViewById(R.id.edit_text_color)).getText().toString()
        )));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            if(data != null && data.hasExtra(SensorActivity.RESULT_KEY)) {
                if (requestCode == 123) {
                    ((TextView)findViewById(R.id.edit_text_color)).setText(String.valueOf(data.getIntExtra(SensorActivity.RESULT_KEY, (int)(Math.random() + 600))));
                } else {
                    ((TextView)findViewById(R.id.edit_text_url)).setText(data.getStringExtra(CameraActivity.RESULT_KEY));
                }
            }
        }
    }

    private void handlePostCreateResponse(BaseResponse<Post> postCreateResponse) {
        if(postCreateResponse != null && postCreateResponse.getData() != null) {
            finish();
        }
    }

    private void handleStatus(BaseData.Status status) {

    }

}
