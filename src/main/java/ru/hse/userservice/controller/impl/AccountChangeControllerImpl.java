package ru.hse.userservice.controller.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.AccountChangeController;
import ru.hse.userservice.dto.request.ProfileCreateRequest;
import ru.hse.userservice.dto.response.FullProfileResponse;
import ru.hse.userservice.dto.response.ShortUserResponse;

@RestController
public class AccountChangeControllerImpl implements AccountChangeController {
    @Override
    public ResponseEntity<FullProfileResponse> createProfile(
            int id, ProfileCreateRequest profileCreateRequest) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<ShortUserResponse> deleteProfile(String id) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<FullProfileResponse> removeTelegram(String id) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<FullProfileResponse> addTelegram(String id) {
        throw new NotImplementedException();
    }
}
