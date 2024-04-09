package ru.orobtsovv.userservice.eventlistener.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.orobtsovv.userservice.dto.messages.FriendRequestAcceptedMessage;

@Getter
public class FriendAcceptEvent extends ApplicationEvent {
    private final FriendRequestAcceptedMessage message;

    public FriendAcceptEvent(Object source, FriendRequestAcceptedMessage message) {
        super(source);
        this.message = message;
    }
}
