package ru.hse.userservice.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.AccountChangeController;
import ru.hse.userservice.dto.request.ProfileCreateRequest;
import ru.hse.userservice.dto.response.FullProfileResponse;
import ru.hse.userservice.dto.response.ShortUserResponse;

@RestController
public class AccountChangeControllerImpl implements AccountChangeController {
    @Override
    public ResponseEntity<FullProfileResponse> createProfile(ProfileCreateRequest profileCreateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<ShortUserResponse> deleteProfile(int userid) {
        return null;
    }

    @Override
    public ResponseEntity<FullProfileResponse> removeTelegram(int userid) {
        return null;
    }

    @Override
    public ResponseEntity<FullProfileResponse> addTelegram(int userid) {
        return null;
    }
}
