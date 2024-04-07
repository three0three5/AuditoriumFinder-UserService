package ru.orobtsovv.userservice.eventlistener.event;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.context.ApplicationEvent;
import ru.orobtsovv.userservice.dto.messages.ProfileDeleteMessage;

import java.time.LocalDateTime;

@Getter
public class ProfileDeleteEvent extends ApplicationEvent {
    private final ProfileDeleteMessage message;

    public ProfileDeleteEvent(Object source, ProfileDeleteMessage message) {
        super(source);
        this.message = message;
    }
}
