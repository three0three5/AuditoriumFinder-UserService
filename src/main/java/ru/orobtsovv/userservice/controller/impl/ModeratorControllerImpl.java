package ru.orobtsovv.userservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import ru.orobtsovv.userservice.controller.ModeratorController;
import ru.orobtsovv.userservice.dto.request.BanRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.dto.response.ReportInfoResponse;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.service.impl.BanService;
import ru.orobtsovv.userservice.service.impl.ProfileService;
import ru.orobtsovv.userservice.service.impl.ReportService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ModeratorControllerImpl implements ModeratorController {
    private final ReportService reportService;
    private final BanService banService;
    private final ProfileService profileService;

    @Override
    public ResponseEntity<List<ReportInfoResponse>> getListOfReportedUsers() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @Override
    public ResponseEntity<ReportInfoResponse> declineReport(int moderatorId, int id) {
        return ResponseEntity.ok(reportService.declineReport(moderatorId, id));
    }

    @Override
    @Transactional
    public ResponseEntity<ShortMessageResponse> banUser(BanRequest request) {
        return ResponseEntity.ok(banService.ban(request));
    }

    @Override
    public ResponseEntity<FullProfileResponse> getProfileData(int id) {
        return ResponseEntity.ok(profileService.getFullProfile(id));
    }
}
