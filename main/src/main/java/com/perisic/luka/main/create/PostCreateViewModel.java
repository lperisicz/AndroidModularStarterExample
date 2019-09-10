package com.perisic.luka.main.create;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.perisic.luka.remote.data.helper.BaseData;
import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.helper.LiveDataResource;
import com.perisic.luka.remote.data.request.PostCreateRequest;
import com.perisic.luka.remote.data.response.Post;
import com.perisic.luka.repository.repos.abstraction.PostRepository;

import javax.inject.Inject;

/**
 * Created by Luka Perisic on 4.9.2019..
 */
public class PostCreateViewModel extends ViewModel {

    private PostRepository postRepository;
    private MutableLiveData<BaseData.Status> status = new MutableLiveData<>();
    private LiveDataResource<BaseResponse<Post>> postCreateResponse = new LiveDataResource<>(status::setValue);

    @Inject
    public PostCreateViewModel(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    void createPost(PostCreateRequest postCreateRequest) {
        postCreateResponse.addLiveDataSource(
                postRepository.createPost(postCreateRequest),
                postCreateResponse::setValue
        );
    }

    LiveData<BaseData.Status> getStatus() {
        return status;
    }

    LiveData<BaseResponse<Post>> getPostCreateResponse() {
        return postCreateResponse;
    }
}
