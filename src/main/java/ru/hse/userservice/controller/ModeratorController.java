package ru.hse.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hse.userservice.dto.response.ReportInfoResponse;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

@RequestMapping("/moderator")
public interface ModeratorController {
    @GetMapping("/reports")
    ResponseEntity<List<ReportInfoResponse>> getListOfReportedUsers();

    @GetMapping("/banned")
    ResponseEntity<List<ShortUserResponse>> getListOfBannedUsers();

    @PostMapping("/reports/{id}/accept")
    ResponseEntity<ReportInfoResponse> acceptReport();

    @PostMapping("/reports/{id}/decline")
    ResponseEntity<ReportInfoResponse> declineReport();

    @PostMapping("/{id}/ban")
    ResponseEntity<ShortUserResponse> banUser();

    @PostMapping("/{id}/cancel_ban")
    ResponseEntity<ShortUserResponse> removeUserFromBanned();
}
