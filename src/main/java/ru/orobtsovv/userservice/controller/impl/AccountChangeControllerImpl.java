package ru.orobtsovv.userservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.orobtsovv.userservice.controller.AccountChangeController;
import ru.orobtsovv.userservice.dto.request.ProfileCreateRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.service.impl.ProfileService;

@RestController
@RequiredArgsConstructor
public class AccountChangeControllerImpl implements AccountChangeController {
    private final ProfileService profileService;

    @Override
    public ResponseEntity<FullProfileResponse> createProfile(ProfileCreateRequest profileCreateRequest) {
        return ResponseEntity.ok(profileService.createProfile(profileCreateRequest));
    }

    @Override
    public ResponseEntity<ShortUserResponse> deleteProfile(int userid) {
        return ResponseEntity.ok(profileService.deleteProfile(userid));
    }

    @Override
    public ResponseEntity<FullProfileResponse> removeTelegram(int userid) {
        return ResponseEntity.ok(profileService.removeTelegram(userid));
    }

    @Override
    public ResponseEntity<FullProfileResponse> addTelegram(int userid, String telegramHandle) {
        return ResponseEntity.ok(profileService.addTelegram(userid, telegramHandle));
    }
}
