package com.perisic.luka.remote.data.request;

/**
 * Created by Luka Perisic on 4.9.2019..
 */
public class PostCreateRequest {

    private String title;
    private String url;
    private String color;

    public PostCreateRequest(String title, String url, String color) {
        this.title = title;
        this.url = url;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
