package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.messages.ProfileDeleteMessage;
import ru.orobtsovv.userservice.dto.request.BanRequest;

@Service
@RequiredArgsConstructor
@Profile("with-mocks")
public class MessageQueryService {

    public void sendDeletedProfile(int moderatorId, BanRequest request) {
        ProfileDeleteMessage event = new ProfileDeleteMessage()
                .setModeratorId(moderatorId)
                .setBannedUntil(request.getBannedUntil())
                .setUserid(request.getUserid())
                .setReason(request.getReason());
        // TODO emit event through mq
    }
}
