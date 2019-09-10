package com.perisic.luka.androidmodularstarterexample.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.helper.LiveDataResource;
import com.perisic.luka.remote.data.response.Post;
import com.perisic.luka.repository.repos.abstraction.PostRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Luka Perisic on 18.6.2019..
 */
class MainViewModel extends ViewModel {

    private PostRepository postRepository;
    private MutableLiveData<BaseData.Status> status = new MutableLiveData<>();
    private LiveDataResource<BaseResponse<List<Post>>> postListResponse = new LiveDataResource<>(status::setValue);

    @Inject
    MainViewModel(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    void fetchWalletStatus() {
        postListResponse.addLiveDataSource(
                postRepository.getPostList(),
                postListResponse::setValue
        );
    }

    LiveDataResource<BaseResponse<List<Post>>> getPostListResponse() {
        return postListResponse;
    }

    LiveData<BaseData.Status> getStatus() {
        return status;
    }
}