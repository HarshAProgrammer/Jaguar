package com.rackluxury.jaguar.reddit;

public interface ActivityToolbarInterface {
    void onLongPress();
    default void displaySortType() {}
}
