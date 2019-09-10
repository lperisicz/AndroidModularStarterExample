package com.perisic.luka.main.single;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.perisic.luka.base.viewModel.ViewModelFactory;
import com.perisic.luka.main.R;
import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.response.Post;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class PostSingleActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;
    private PostSingleViewModel postSingleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_single);

        postSingleViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostSingleViewModel.class);
        postSingleViewModel.getStatus().observe(this, this::handleStatus);
        postSingleViewModel.getPostResponse().observe(this, this::handlePostResponse);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent() != null && getIntent().hasExtra("id")) {
            postSingleViewModel.getSinglePost(getIntent().getIntExtra("id", 0));
        }
    }

    private void handlePostResponse(BaseResponse<Post> postResponse) {
        if (postResponse != null && postResponse.getData() != null) {
            try {
                findViewById(R.id.constraint_layout_post).setBackgroundColor(Color.parseColor(postResponse.getData().getColor()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            ((TextView)findViewById(R.id.text_view_title)).setText(postResponse.getData().getTitle());
            ((TextView)findViewById(R.id.text_view_author)).setText(postResponse.getData().getUser().getName());
            Glide.with(findViewById(R.id.image_view_single_post))
                    .load(postResponse.getData().getUrl())
                    .placeholder(new ColorDrawable(ContextCompat.getColor(this, R.color.colorAccent)))
                    .into((ImageView)findViewById(R.id.image_view_single_post));
        }
    }

    private void handleStatus(BaseData.Status status) {

    }
}
