package ru.orobtsovv.userservice.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.orobtsovv.userservice.dto.messages.ProfileDeleteMessage;
import ru.orobtsovv.userservice.eventlistener.event.ProfileDeleteEvent;

import java.util.List;

import static ru.orobtsovv.userservice.utils.constants.MQConstants.PROFILE_DELETE_AUD;
import static ru.orobtsovv.userservice.utils.constants.MQConstants.PROFILE_DELETE_AUTH;
import static ru.orobtsovv.userservice.utils.constants.MQConstants.PROFILE_DELETE_NOTIFICATIONS;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProfileDeleteListener implements ApplicationListener<ProfileDeleteEvent> {
    private static final List<String> destinationQueues = List.of(
            PROFILE_DELETE_AUTH, PROFILE_DELETE_AUD, PROFILE_DELETE_NOTIFICATIONS);
    private final RabbitTemplate template;

    @Override
    public void onApplicationEvent(ProfileDeleteEvent event) {
        ProfileDeleteMessage message = event.getMessage();
        log.info("Caught profile delete event: %s".formatted(message));
        destinationQueues.forEach(destination -> template.convertAndSend(destination, message));
    }
}
