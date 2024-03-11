package ru.hse.userservice.controller.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.UsersController;
import ru.hse.userservice.dto.request.ReportRequest;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

@RestController
public class UsersControllerImpl implements UsersController {
    @Override
    public ResponseEntity<List<ShortUserResponse>> searchByCriteria(String nickname, List<String> tagIds) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<ShortUserResponse> reportUser(ReportRequest reportRequest, int id) {
        throw new NotImplementedException();
    }
}
