package ru.orobtsovv.userservice.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.orobtsovv.userservice.dto.messages.FriendDeleteMessage;
import ru.orobtsovv.userservice.eventlistener.event.FriendDeleteEvent;

import static ru.orobtsovv.userservice.utils.constants.MQConstants.FRIEND_LINK_DELETED;

@Component
@Slf4j
@RequiredArgsConstructor
public class FriendDeleteListener implements ApplicationListener<FriendDeleteEvent> {
    private final RabbitTemplate template;

    @Override
    public void onApplicationEvent(FriendDeleteEvent event) {
        FriendDeleteMessage message = event.getMessage();
        log.info("on friend delete: %s".formatted(message));
        template.convertAndSend(FRIEND_LINK_DELETED, message);
    }
}
