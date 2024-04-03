package ru.orobtsovv.userservice.service.impl;

import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;

import java.util.List;

@Service
public class UserService {
    public List<ShortUserResponse> searchBy(int userid, String nickname, List<String> tagIds) {
        return null;
    }
}
