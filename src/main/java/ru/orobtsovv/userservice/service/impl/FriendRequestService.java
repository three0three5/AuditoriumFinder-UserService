package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendRequestService {

    public List<ShortUserResponse> getIncomingRequests(int userid) {
        return null;
    }

    public List<ShortUserResponse> getOutgoingRequests(int userid) {
        return null;
    }

    public ShortUserResponse makeRequest(int userid, int id) {
        return null;
    }

    public ShortUserResponse declineRequest(int userid, int id) {
        return null;
    }

    public ShortUserResponse cancelRequest(int userid, int id) {
        return null;
    }
}
