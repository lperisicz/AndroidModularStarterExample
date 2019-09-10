package com.perisic.luka.remote.config;

/**
 * Created by Luka Perisic on 17.6.2019..
 */
public interface PostServiceConfig {

    String ROUTE_POST = "post";
    String ROUTE_POST_ALL = ROUTE_POST + "/all";
    String ROUTE_POST_CREATE = ROUTE_POST;
    String ROUTE_POST_SINGLE = ROUTE_POST + "/{id}";

}