package com.perisic.luka.repository.repos.abstraction;

import androidx.lifecycle.LiveData;

import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.request.PostCreateRequest;
import com.perisic.luka.remote.data.response.Post;
import com.perisic.luka.repository.repos.BaseRepository;

import java.util.List;

/**
 * Created by Luka Perisic on 17.6.2019..
 */
public interface PostRepository extends BaseRepository {

    LiveData<BaseResponse<List<Post>>> getPostList();

    LiveData<BaseResponse<Post>> createPost(PostCreateRequest postCreateRequest);

    LiveData<BaseResponse<Post>> getSinglePost(int id);
}
