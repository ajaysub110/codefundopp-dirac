package com.example.ajays.dirac.Forum;

public class ForumModel {
    String post_title;
    Integer num_replies;
    Integer num_upvotes;

    public ForumModel(String post_title, Integer num_replies, Integer num_upvotes) {

        this.post_title = post_title;
        this.num_replies = num_replies;
        this.num_upvotes = num_upvotes;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public Integer getNum_replies() {
        return num_replies;
    }

    public void setNum_replies(Integer num_replies) {
        this.num_replies = num_replies;
    }

    public Integer getNum_upvotes() {
        return num_upvotes;
    }

    public void setNum_upvotes(Integer num_upvotes) {
        this.num_upvotes = num_upvotes;
    }


}
