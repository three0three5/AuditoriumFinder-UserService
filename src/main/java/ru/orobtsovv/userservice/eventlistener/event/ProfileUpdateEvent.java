package ru.orobtsovv.userservice.eventlistener.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.orobtsovv.userservice.dto.messages.ProfileUpdateMessage;

@Getter
public class ProfileUpdateEvent extends ApplicationEvent {
    private final ProfileUpdateMessage message;
    public ProfileUpdateEvent(Object source, ProfileUpdateMessage message) {
        super(source);
        this.message = message;
    }
}
