package com.perisic.luka.remote.data.response;

/**
 * Created by Luka Perisic on 17.6.2019..
 */
public class Post {

    private int id;
    private String title;
    private String url;
    private String color;
    private long createdAt;
    private UserDetails user;

    public Post(int id, String title, String url, String color, long createdAt, UserDetails user) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.color = color;
        this.createdAt = createdAt;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public static class UserDetails {

        private String name;

        public UserDetails(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
