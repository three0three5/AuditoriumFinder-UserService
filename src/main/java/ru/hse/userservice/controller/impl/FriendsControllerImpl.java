package ru.hse.userservice.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.FriendsController;
import ru.hse.userservice.dto.response.ShortMessageResponse;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

@RestController
public class FriendsControllerImpl implements FriendsController {
    @Override
    public ResponseEntity<List<ShortUserResponse>> getFriendList(int userid) {
        return null;
    }

    @Override
    public ResponseEntity<ShortMessageResponse> subscribeToNotificationsFromUser(int id, int userid) {
        return null;
    }

    @Override
    public ResponseEntity<ShortMessageResponse> unsubscribeFromNotificationsFromUser(int id, int userid) {
        return null;
    }

    @Override
    public ResponseEntity<ShortUserResponse> removeFromFriendList(int id, int userid) {
        return null;
    }
}
