package com.rackluxury.jaguar.reddit.events;

public class ChangeMuteAutoplayingVideosEvent {
    public boolean muteAutoplayingVideos;

    public ChangeMuteAutoplayingVideosEvent(boolean muteAutoplayingVideos) {
        this.muteAutoplayingVideos = muteAutoplayingVideos;
    }
}
