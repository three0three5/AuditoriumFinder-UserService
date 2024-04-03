package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.request.ProfileChangeRequest;
import ru.orobtsovv.userservice.dto.request.ProfileCreateRequest;
import ru.orobtsovv.userservice.dto.request.VisibilityChangeRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;

@Service
@RequiredArgsConstructor
public class ProfileService {

    public FullProfileResponse createProfile(ProfileCreateRequest profileCreateRequest) {
        return null; // TODO
    }


    public ShortUserResponse deleteProfile(int userid) {
        return null;
    }


    public FullProfileResponse removeTelegram(int userid) {
        return null;
    }

    public FullProfileResponse addTelegram(int userid, String telegramHandle) {
        return null;
    }

    public FullProfileResponse getFullProfile(int id) {
        return null;
    }

    public FullProfileResponse editNickname(int userid, ProfileChangeRequest profileChangeRequest) {
        return null;
    }

    public FullProfileResponse getFilteredProfile(int userid, Integer id) {
        return null;
    }

    public FullProfileResponse changeVisibility(int userid, VisibilityChangeRequest visibilityChangeRequest) {
        return null;
    }
}
