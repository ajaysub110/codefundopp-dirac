package com.example.ajays.dirac.Forum;

public class ForumModel {
    String post_title;
    String post_description;
    Integer num_upvotes;

    public ForumModel(){}

    public ForumModel(String post_title, String post_description, Integer num_upvotes) {

        this.post_title = post_title;
        this.post_description = post_description;
        this.num_upvotes = num_upvotes;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public Integer getNum_upvotes() {
        return num_upvotes;
    }

    public void setNum_upvotes(Integer num_upvotes) {
        this.num_upvotes = num_upvotes;
    }

    public String getPost_description() {
        return post_description;
    }

    public void setPost_description(String post_description) {
        this.post_description = post_description;
    }
}
