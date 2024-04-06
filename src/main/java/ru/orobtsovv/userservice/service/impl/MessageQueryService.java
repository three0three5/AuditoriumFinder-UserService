package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.messages.ProfileDeleteMessage;
import ru.orobtsovv.userservice.dto.request.BanRequest;

@Service
@RequiredArgsConstructor
@Profile("with-mocks")
@Slf4j
public class MessageQueryService {

    public void sendDeletedProfile(ProfileDeleteMessage message) {
        // TODO emit event through mq
        log.info("Delete profile message sent");
    }
}
