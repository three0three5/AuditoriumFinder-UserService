package ru.hse.userservice.controller.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.RequestsController;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

@RestController
public class RequestsControllerImpl implements RequestsController {
    @Override
    public ResponseEntity<List<ShortUserResponse>> getIncomingRequests() {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<List<ShortUserResponse>> getOutgoingRequests() {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<ShortUserResponse> makeFriendRequest(int id) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<ShortUserResponse> declineIncomingRequestFromUser(int id) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<ShortUserResponse> removeOutgoingRequest(int id) {
        throw new NotImplementedException();
    }
}
