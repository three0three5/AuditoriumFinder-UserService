package ru.orobtsovv.userservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.orobtsovv.userservice.controller.RequestsController;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.service.impl.FriendRequestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestsControllerImpl implements RequestsController {
    private final FriendRequestService service;

    @Override
    public ResponseEntity<List<ShortUserResponse>> getIncomingRequests(int userid) {
        return ResponseEntity.ok(service.getIncomingRequests(userid));
    }

    @Override
    public ResponseEntity<List<ShortUserResponse>> getOutgoingRequests(int userid) {
        return ResponseEntity.ok(service.getOutgoingRequests(userid));
    }

    @Override
    public ResponseEntity<ShortUserResponse> makeFriendRequest(int userid, int id) {
        return ResponseEntity.ok(service.makeRequest(userid, id));
    }

    @Override
    public ResponseEntity<ShortUserResponse> declineIncomingRequestFromUser(int userid, int id) {
        return ResponseEntity.ok(service.declineRequest(userid, id));
    }

    @Override
    public ResponseEntity<ShortUserResponse> removeOutgoingRequest(int userid, int id) {
        return ResponseEntity.ok(service.cancelRequest(userid, id));
    }
}
