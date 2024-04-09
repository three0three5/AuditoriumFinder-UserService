package ru.orobtsovv.userservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.orobtsovv.userservice.controller.ProfileController;
import ru.orobtsovv.userservice.dto.request.ProfileChangeRequest;
import ru.orobtsovv.userservice.dto.request.ProfilesRequest;
import ru.orobtsovv.userservice.dto.request.VisibilityChangeRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.service.impl.ProfileService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProfileControllerImpl implements ProfileController {
    private final ProfileService profileService;

    @Override
    public ResponseEntity<FullProfileResponse> editNickname(
            int userid, ProfileChangeRequest profileChangeRequest) {
        return ResponseEntity.ok(profileService.editNickname(userid, profileChangeRequest));
    }

    @Override
    public ResponseEntity<FullProfileResponse> getProfileData(int userid, Integer id) {
        return ResponseEntity.ok(profileService.getFilteredProfile(userid, id));
    }

    @Override
    public ResponseEntity<FullProfileResponse> changeVisibility(
            int userid, VisibilityChangeRequest visibilityChangeRequest) {
        return ResponseEntity.ok(profileService.changeVisibility(userid, visibilityChangeRequest));
    }

    @Override
    public ResponseEntity<Map<Integer, FullProfileResponse>> mapIntToProfiles(int userid, ProfilesRequest request) {
        return ResponseEntity.ok(profileService.mapIdsToProfiles(userid, request));
    }
}
