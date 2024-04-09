package ru.orobtsovv.userservice.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.orobtsovv.userservice.dto.messages.FriendRequestReceivedMessage;
import ru.orobtsovv.userservice.eventlistener.event.FriendRequestReceivedEvent;

import static ru.orobtsovv.userservice.utils.constants.MQConstants.FRIEND_REQUEST_RECEIVED;

@Component
@Slf4j
@RequiredArgsConstructor
public class FriendRequestReceivedListener implements ApplicationListener<FriendRequestReceivedEvent> {
    private final RabbitTemplate template;

    @Override
    public void onApplicationEvent(FriendRequestReceivedEvent event) {
        FriendRequestReceivedMessage message = event.getMessage();
        log.info("on friend request received: %s".formatted(message));
        template.convertAndSend(FRIEND_REQUEST_RECEIVED, message);
    }
}
