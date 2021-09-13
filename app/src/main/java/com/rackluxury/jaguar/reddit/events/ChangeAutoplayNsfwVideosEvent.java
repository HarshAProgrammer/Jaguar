package com.rackluxury.jaguar.reddit.events;

public class ChangeAutoplayNsfwVideosEvent {
    public boolean autoplayNsfwVideos;

    public ChangeAutoplayNsfwVideosEvent(boolean autoplayNsfwVideos) {
        this.autoplayNsfwVideos = autoplayNsfwVideos;
    }
}
