package ru.orobtsovv.userservice.eventlistener.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.orobtsovv.userservice.dto.messages.FriendRequestReceivedMessage;

@Getter
public class FriendRequestReceivedEvent extends ApplicationEvent {
    private final FriendRequestReceivedMessage message;

    public FriendRequestReceivedEvent(Object source, FriendRequestReceivedMessage message) {
        super(source);
        this.message = message;
    }
}
