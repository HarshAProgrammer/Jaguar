package com.rackluxury.jaguar.reddit.events;

public class ChangeHideSubredditAndUserPrefixEvent {
    public boolean hideSubredditAndUserPrefix;

    public ChangeHideSubredditAndUserPrefixEvent(boolean hideSubredditAndUserPrefix) {
        this.hideSubredditAndUserPrefix = hideSubredditAndUserPrefix;
    }
}
