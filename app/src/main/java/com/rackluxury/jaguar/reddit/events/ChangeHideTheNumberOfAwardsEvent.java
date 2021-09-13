package com.rackluxury.jaguar.reddit.events;

public class ChangeHideTheNumberOfAwardsEvent {
    public boolean hideTheNumberOfAwards;

    public ChangeHideTheNumberOfAwardsEvent(boolean hideTheNumberOfAwards) {
        this.hideTheNumberOfAwards = hideTheNumberOfAwards;
    }
}
