package ru.hse.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hse.userservice.dto.response.ShortMessageResponse;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

@RequestMapping("/friends")
public interface FriendsController {
    @GetMapping
    ResponseEntity<List<ShortUserResponse>> getFriendList();

    @PostMapping("/{id}/subscribe")
    ResponseEntity<ShortMessageResponse> subscribeToNotificationsFromUser();

    @PostMapping("/{id}/unsubscribe")
    ResponseEntity<ShortMessageResponse> unsubscribeFromNotificationsFromUser();

    @PatchMapping("/{id}/remove")
    ResponseEntity<ShortUserResponse> removeFromFriendList();
}
