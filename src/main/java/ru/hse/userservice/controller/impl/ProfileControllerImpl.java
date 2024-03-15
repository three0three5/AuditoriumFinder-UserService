package ru.hse.userservice.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.ProfileController;
import ru.hse.userservice.dto.request.ProfileChangeRequest;
import ru.hse.userservice.dto.request.VisibilityChangeRequest;
import ru.hse.userservice.dto.response.FullProfileResponse;

@RestController
public class ProfileControllerImpl implements ProfileController {
    @Override
    public ResponseEntity<FullProfileResponse> editNickname(int userid, ProfileChangeRequest profileChangeRequest) {
        return null;
    }

    @Override
    public ResponseEntity<FullProfileResponse> getProfileData(int userid, int id) {
        return null;
    }

    @Override
    public ResponseEntity<FullProfileResponse> changeVisibility(int userid, VisibilityChangeRequest visibilityChangeRequest) {
        return null;
    }
}
