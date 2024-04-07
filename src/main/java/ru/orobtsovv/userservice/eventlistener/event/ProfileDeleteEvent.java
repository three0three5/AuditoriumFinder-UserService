package ru.orobtsovv.userservice.eventlistener.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.orobtsovv.userservice.dto.messages.ProfileDeleteMessage;

@Getter
public class ProfileDeleteEvent extends ApplicationEvent {
    private final ProfileDeleteMessage message;

    public ProfileDeleteEvent(Object source, ProfileDeleteMessage message) {
        super(source);
        this.message = message;
    }
}
