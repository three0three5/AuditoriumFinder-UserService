package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;

@Service
@RequiredArgsConstructor
public class BanService {

    public ShortUserResponse ban(int moderatorId, int id) {
        return null;
    }
}
