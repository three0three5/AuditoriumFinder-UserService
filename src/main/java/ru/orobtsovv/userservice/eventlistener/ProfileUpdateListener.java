package ru.orobtsovv.userservice.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.orobtsovv.userservice.eventlistener.event.ProfileUpdateEvent;

import static ru.orobtsovv.userservice.utils.constants.MQConstants.PROFILE_UPDATE;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProfileUpdateListener implements ApplicationListener<ProfileUpdateEvent> {
    private final RabbitTemplate template;

    @Override
    public void onApplicationEvent(ProfileUpdateEvent event) {
        log.info("on profile update: %s".formatted(event));
        template.convertAndSend(PROFILE_UPDATE, event);
    }
}
