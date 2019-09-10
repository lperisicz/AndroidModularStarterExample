package com.perisic.luka.main.list;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.perisic.luka.base.FeatureNavigation;
import com.perisic.luka.base.viewModel.ViewModelFactory;
import com.perisic.luka.main.R;
import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.response.Post;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import static com.perisic.luka.base.FeatureNavigation.DESTINATION;

public class PostListActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;
    @Inject
    FeatureNavigation featureNavigation;
    private PostListViewModel postListViewModel;
    private PostListAdapter postListAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        postListViewModel = ViewModelProviders.of(this, viewModelFactory).get(PostListViewModel.class);
        findViewById(R.id.fab_add_post).setOnClickListener(v -> featureNavigation.navigate(this, DESTINATION.POST_CREATE));
        recyclerView = findViewById(R.id.recycler_view_post);

        postListAdapter = new PostListAdapter(id -> featureNavigation.navigate(
                this,
                new Intent(this, PostListActivity.class).putExtra("id", id),
                DESTINATION.POST_SINGLE
        ));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postListAdapter);

        postListViewModel.getStatus().observe(this, this::handleStatus);
        postListViewModel.getPostListResponse().observe(this, this::handlePostListResponse);
    }

    @Override
    protected void onResume() {
        super.onResume();
        postListViewModel.getPostList();
    }

    private void handlePostListResponse(BaseResponse<List<Post>> postListResponse) {
        if (postListResponse.getData() != null) {
            postListAdapter.addItems(postListResponse.getData());
        }
    }

    private void handleStatus(BaseData.Status status) {
        Snackbar.make(recyclerView, status.name(), Snackbar.LENGTH_SHORT);
    }
}
