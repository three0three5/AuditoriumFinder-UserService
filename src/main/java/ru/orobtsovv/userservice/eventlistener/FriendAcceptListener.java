package ru.orobtsovv.userservice.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.orobtsovv.userservice.dto.messages.FriendRequestAcceptedMessage;
import ru.orobtsovv.userservice.eventlistener.event.FriendAcceptEvent;

import static ru.orobtsovv.userservice.utils.constants.MQConstants.FRIEND_REQUEST_ACCEPTED;

@Component
@Slf4j
@RequiredArgsConstructor
public class FriendAcceptListener implements ApplicationListener<FriendAcceptEvent> {
    private final RabbitTemplate template;

    @Override
    public void onApplicationEvent(FriendAcceptEvent event) {
        FriendRequestAcceptedMessage message = event.getMessage();
        log.info("on friend accept: %s".formatted(message));
        template.convertAndSend(FRIEND_REQUEST_ACCEPTED, message);
    }
}
