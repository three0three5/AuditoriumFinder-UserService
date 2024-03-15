package ru.hse.userservice.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.ModeratorController;
import ru.hse.userservice.dto.response.BanInfoResponse;
import ru.hse.userservice.dto.response.FullProfileResponse;
import ru.hse.userservice.dto.response.ReportInfoResponse;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

@RestController
public class ModeratorControllerImpl implements ModeratorController {
    @Override
    public ResponseEntity<List<ReportInfoResponse>> getListOfReportedUsers() {
        return null;
    }

    @Override
    public ResponseEntity<List<BanInfoResponse>> getListOfBannedUsers() {
        return null;
    }

    @Override
    public ResponseEntity<ReportInfoResponse> declineReport(int moderatorId, int id) {
        return null;
    }

    @Override
    public ResponseEntity<ShortUserResponse> banUser(int moderatorId, int id) {
        return null;
    }

    @Override
    public ResponseEntity<ShortUserResponse> removeUserFromBanned(int moderatorId, int id) {
        return null;
    }

    @Override
    public ResponseEntity<FullProfileResponse> getProfileData(int moderatorId, int id) {
        return null;
    }
}
