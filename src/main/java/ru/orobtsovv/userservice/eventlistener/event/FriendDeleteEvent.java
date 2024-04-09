package ru.orobtsovv.userservice.eventlistener.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.orobtsovv.userservice.dto.messages.FriendDeleteMessage;

@Getter
public class FriendDeleteEvent extends ApplicationEvent {
    private final FriendDeleteMessage message;
    public FriendDeleteEvent(Object source, FriendDeleteMessage message) {
        super(source);
        this.message = message;
    }
}
