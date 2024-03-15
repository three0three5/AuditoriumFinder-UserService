package ru.hse.userservice.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.RequestsController;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

@RestController
public class RequestsControllerImpl implements RequestsController {
    @Override
    public ResponseEntity<List<ShortUserResponse>> getIncomingRequests(int userid) {
        return null;
    }

    @Override
    public ResponseEntity<List<ShortUserResponse>> getOutgoingRequests(int userid) {
        return null;
    }

    @Override
    public ResponseEntity<ShortUserResponse> makeFriendRequest(int userid, int id) {
        return null;
    }

    @Override
    public ResponseEntity<ShortUserResponse> declineIncomingRequestFromUser(int userid, int id) {
        return null;
    }

    @Override
    public ResponseEntity<ShortUserResponse> removeOutgoingRequest(int userid, int id) {
        return null;
    }
}
