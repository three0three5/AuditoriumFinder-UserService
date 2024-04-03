package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;

@Service
@RequiredArgsConstructor
public class NotificationService {

    public ShortMessageResponse subscribe(int fromId, int toId) {
        return null;
    }

    public ShortMessageResponse unsubscribe(int fromId, int toId) {
        return null;
    }
}
