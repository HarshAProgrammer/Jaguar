package com.rackluxury.jaguar.reddit.events;

public class ChangeDisableImagePreviewEvent {
    public boolean disableImagePreview;

    public ChangeDisableImagePreviewEvent(boolean disableImagePreview) {
        this.disableImagePreview = disableImagePreview;
    }
}
