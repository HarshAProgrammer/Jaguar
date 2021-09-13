package com.rackluxury.jaguar.reddit.events;

import java.util.ArrayList;

import com.rackluxury.jaguar.reddit.post.Post;

public class ProvidePostListToViewPostDetailActivityEvent {
    public long postFragmentId;
    public ArrayList<Post> posts;

    public ProvidePostListToViewPostDetailActivityEvent(long postFragmentId, ArrayList<Post> posts) {
        this.postFragmentId = postFragmentId;
        this.posts = posts;
    }
}
