package ru.orobtsovv.userservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.orobtsovv.userservice.controller.UsersController;
import ru.orobtsovv.userservice.dto.request.ReportRequest;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.service.impl.ReportService;
import ru.orobtsovv.userservice.service.impl.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersControllerImpl implements UsersController {
    private final UserService service;
    private final ReportService reportService;

    @Override
    public ResponseEntity<List<ShortUserResponse>> searchByCriteria(
            int userid, String nickname, List<String> tagIds) {
        return ResponseEntity.ok(service.searchBy(userid, nickname, tagIds));
    }

    @Override
    public ResponseEntity<ShortUserResponse> reportUser(int userid, ReportRequest reportRequest, int id) {
        return ResponseEntity.ok(reportService.makeReport(userid, reportRequest, id));
    }
}
