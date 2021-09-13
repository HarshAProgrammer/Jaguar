package com.rackluxury.jaguar.reddit.events;

import com.rackluxury.jaguar.reddit.message.Message;

public class RepliedToPrivateMessageEvent {
    public Message newReply;
    public int messagePosition;

    public RepliedToPrivateMessageEvent(Message newReply, int messagePosition) {
        this.newReply = newReply;
        this.messagePosition = messagePosition;
    }
}
