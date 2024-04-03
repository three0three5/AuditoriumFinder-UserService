package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {
    public List<ShortUserResponse> getFriendList(int userid) {
        return null;
    }

    public ShortMessageResponse removeFriend(int userid, int id) {
        return null;
    }
}
