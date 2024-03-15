package ru.hse.userservice.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.UsersController;
import ru.hse.userservice.dto.request.ReportRequest;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

@RestController
public class UsersControllerImpl implements UsersController {
    @Override
    public ResponseEntity<List<ShortUserResponse>> searchByCriteria(int userid, String nickname, List<String> tagIds) {
        return null;
    }

    @Override
    public ResponseEntity<ShortUserResponse> reportUser(int userid, ReportRequest reportRequest, int id) {
        return null;
    }
}
