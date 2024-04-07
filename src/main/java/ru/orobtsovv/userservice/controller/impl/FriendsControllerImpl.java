package ru.orobtsovv.userservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.orobtsovv.userservice.controller.FriendsController;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.service.impl.FriendService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FriendsControllerImpl implements FriendsController {
    private final FriendService friendService;

    @Override
    public ResponseEntity<List<ShortUserResponse>> getFriendList(int userid) {
        return ResponseEntity.ok(friendService.getFriendList(userid));
    }

    @Override
    public ResponseEntity<ShortMessageResponse> removeFromFriendList(int id, int userid) {
        return ResponseEntity.ok(friendService.removeFriend(userid, id));
    }

    @Override
    public ResponseEntity<Boolean> areFriends(int id1, int id2) {
        return ResponseEntity.ok(friendService.areFriends(id1, id2));
    }
}
