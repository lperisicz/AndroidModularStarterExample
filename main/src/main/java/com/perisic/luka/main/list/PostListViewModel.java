package com.perisic.luka.main.list;

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
 * Created by Luka Perisic on 3.9.2019..
 */
class PostListViewModel extends ViewModel {

    private PostRepository postRepository;
    private MutableLiveData<BaseData.Status> status = new MutableLiveData<>();
    private LiveDataResource<BaseResponse<List<Post>>> postListResponse = new LiveDataResource<>(status::setValue);

    @Inject
    PostListViewModel(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    void getPostList() {
        postListResponse.addLiveDataSource(
                postRepository.getPostList(),
                postListResponse::setValue
        );
    }

    LiveData<BaseData.Status> getStatus() {
        return status;
    }

    LiveData<BaseResponse<List<Post>>> getPostListResponse() {
        return postListResponse;
    }
}
