package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.messages.ProfileDeleteEvent;
import ru.orobtsovv.userservice.dto.request.BanRequest;

@Service
@RequiredArgsConstructor
public class MessageQueryService {

    public void sendDeletedProfile(BanRequest request) {
        ProfileDeleteEvent event = new ProfileDeleteEvent()
                .setModeratorId(request.getModeratorId())
                .setBannedUntil(request.getBannedUntil())
                .setUserid(request.getUserid())
                .setReason(request.getReason());
        // TODO emit event through mq
    }
}
