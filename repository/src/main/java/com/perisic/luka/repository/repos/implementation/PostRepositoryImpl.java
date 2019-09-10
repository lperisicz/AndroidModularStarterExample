package com.perisic.luka.repository.repos.implementation;

import androidx.lifecycle.LiveData;

import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.request.PostCreateRequest;
import com.perisic.luka.remote.data.response.Post;
import com.perisic.luka.remote.services.PostService;
import com.perisic.luka.repository.repos.abstraction.PostRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Luka Perisic on 17.6.2019..
 */
public class PostRepositoryImpl implements PostRepository {

    private PostService postService;

    @Inject
    PostRepositoryImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public LiveData<BaseResponse<List<Post>>> getPostList() {
        return executeCall(postService.getPostList());
    }

    @Override
    public LiveData<BaseResponse<Post>> createPost(PostCreateRequest postCreateRequest) {
        return executeCall(postService.createPost(postCreateRequest));
    }

    @Override
    public LiveData<BaseResponse<Post>> getSinglePost(int id) {
        return executeCall(postService.getSinglePost(id));
    }
}