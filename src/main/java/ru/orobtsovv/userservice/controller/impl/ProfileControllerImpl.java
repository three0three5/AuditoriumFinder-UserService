package ru.orobtsovv.userservice.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.orobtsovv.userservice.controller.ProfileController;
import ru.orobtsovv.userservice.dto.request.ProfileChangeRequest;
import ru.orobtsovv.userservice.dto.request.VisibilityChangeRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;

@RestController
public class ProfileControllerImpl implements ProfileController {
    @Override
    public ResponseEntity<FullProfileResponse> editNickname(
            int userid, ProfileChangeRequest profileChangeRequest) {
        return null;
    }

    @Override
    public ResponseEntity<FullProfileResponse> getProfileData(int userid, Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<FullProfileResponse> changeVisibility(
            int userid, VisibilityChangeRequest visibilityChangeRequest) {
        return null;
    }
}
