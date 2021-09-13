package com.rackluxury.jaguar.reddit.events;

import com.rackluxury.jaguar.reddit.post.Post;

public class PostUpdateEventToPostDetailFragment {
    public final Post post;

    public PostUpdateEventToPostDetailFragment(Post post) {
        this.post = post;
    }
}
