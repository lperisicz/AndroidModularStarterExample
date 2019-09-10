package com.perisic.luka.remote.services;

import com.perisic.luka.remote.data.helper.BaseResponse;
import com.perisic.luka.remote.data.request.PostCreateRequest;
import com.perisic.luka.remote.data.response.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static com.perisic.luka.remote.config.PostServiceConfig.ROUTE_POST_ALL;
import static com.perisic.luka.remote.config.PostServiceConfig.ROUTE_POST_CREATE;
import static com.perisic.luka.remote.config.PostServiceConfig.ROUTE_POST_SINGLE;

/**
 * S
 * Created by Luka Perisic on 17.6.2019..
 */
public interface PostService {

    @GET(ROUTE_POST_ALL)
    Call<BaseResponse<List<Post>>> getPostList();

    @POST(ROUTE_POST_CREATE)
    Call<BaseResponse<Post>> createPost(@Body PostCreateRequest postCreateRequest);

    @GET(ROUTE_POST_SINGLE)
    Call<BaseResponse<Post>> getSinglePost(@Path("id") int id);
}