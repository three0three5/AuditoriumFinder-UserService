package ru.hse.userservice.controller.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.ProfileController;
import ru.hse.userservice.dto.request.ProfileChangeRequest;
import ru.hse.userservice.dto.request.VisibilityChangeRequest;
import ru.hse.userservice.dto.response.FullProfileResponse;

@RestController
public class ProfileControllerImpl implements ProfileController {
    @Override
    public ResponseEntity<FullProfileResponse> editNickname(ProfileChangeRequest profileChangeRequest) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<FullProfileResponse> getProfileData(int id) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<FullProfileResponse> changeVisibility(VisibilityChangeRequest visibilityChangeRequest) {
        throw new NotImplementedException();
    }
}
