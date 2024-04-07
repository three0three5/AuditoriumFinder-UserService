package ru.orobtsovv.userservice.mqhandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.dto.messages.AddTelegramMessage;
import ru.orobtsovv.userservice.dto.messages.ProfileCreateRequest;
import ru.orobtsovv.userservice.dto.messages.RemoveTelegramMessage;
import ru.orobtsovv.userservice.service.impl.ProfileService;

import static ru.orobtsovv.userservice.utils.constants.MQConstants.PROFILE_CREATE;
import static ru.orobtsovv.userservice.utils.constants.MQConstants.TELEGRAM_REMOVE;
import static ru.orobtsovv.userservice.utils.constants.MQConstants.TELEGRAM_SAVE;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthServiceListener {
    private final ProfileService profileService;

    @RabbitListener(queues = PROFILE_CREATE)
    @Transactional
    public void profileCreate(ProfileCreateRequest message) {
        log.info("received mq message for profile create: " + message);
        profileService.createProfile(message);
    }

    @RabbitListener(queues = TELEGRAM_REMOVE)
    @Transactional
    public void removeTelegram(RemoveTelegramMessage message) {
        log.info("remove telegram mq request for %d".formatted(message.getUserid()));
        profileService.removeTelegram(message.getUserid());
    }

    @RabbitListener(queues = TELEGRAM_SAVE)
    @Transactional
    public void addTelegram(AddTelegramMessage message) {
        log.info("add telegram %s mq request for %d".formatted(message.getTelegramHandle(), message.getUserid()));
        profileService.addTelegram(message.getUserid(), message.getTelegramHandle());
    }
}
