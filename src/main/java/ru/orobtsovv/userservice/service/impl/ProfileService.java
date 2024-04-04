package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.dto.request.ProfileChangeRequest;
import ru.orobtsovv.userservice.dto.request.ProfileCreateRequest;
import ru.orobtsovv.userservice.dto.request.VisibilityChangeRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.exception.ProfileNotFoundException;
import ru.orobtsovv.userservice.mapper.ProfileMapper;

import static ru.orobtsovv.userservice.utils.constants.CommonConstants.DELETED_PROFILE_SUCCESS;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final DeleteService deleteService;
    private final ProfileMapper profileMapper;

    public FullProfileResponse createProfile(ProfileCreateRequest profileCreateRequest) {
        ProfileEntity entity = profileMapper.profileCreateRequestToProfileEntity(profileCreateRequest);
        entity = profileRepository.save(entity);
        return new FullProfileResponse()
                .setUserid(entity.getUserid())
                .setNickname(entity.getNickname());
    }

    public ShortMessageResponse deleteProfile(int userid) {
        deleteService.deleteAllInfo(userid);
        return new ShortMessageResponse()
                .setMessage(DELETED_PROFILE_SUCCESS.formatted(userid));
    }


    public FullProfileResponse removeTelegram(int userid) {
        ProfileEntity entity = profileRepository.findById(userid).orElseThrow(ProfileNotFoundException::new);
        entity.setTelegramHandle(null);
        profileRepository.save(entity);
        return profileMapper.profileEntityToFullProfileResponse(entity);
    }

    public FullProfileResponse addTelegram(int userid, String telegramHandle) {
        ProfileEntity entity = profileRepository.findById(userid).orElseThrow(ProfileNotFoundException::new);
        entity.setTelegramHandle(telegramHandle);
        profileRepository.save(entity);
        return profileMapper.profileEntityToFullProfileResponse(entity);
    }

    public FullProfileResponse getFullProfile(int id) {
        ProfileEntity entity = profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new);
        return profileMapper.profileEntityToFullProfileResponse(entity);
    }

    public FullProfileResponse editNickname(int userid, ProfileChangeRequest profileChangeRequest) {
        ProfileEntity entity = profileRepository.findById(userid).orElseThrow(ProfileNotFoundException::new);
        entity.setNickname(profileChangeRequest.getNickname());
        profileRepository.save(entity);
        return profileMapper.profileEntityToFullProfileResponse(entity);
    }

    public FullProfileResponse getFilteredProfile(int userid, Integer id) {
        ProfileEntity entity = profileRepository.findById(userid)
                .orElseThrow(ProfileNotFoundException::new);
        if (id == null) {
            return profileMapper.profileEntityToFullProfileResponse(entity);
        }
        boolean areFriends = profileRepository.areFriends(userid, id);
        return profileMapper.profileEntityToFullProfileResponseFiltered(entity, areFriends);
    }

    public FullProfileResponse changeVisibility(int userid, VisibilityChangeRequest visibilityChangeRequest) {
        ProfileEntity entity = profileRepository.findById(userid).orElseThrow(ProfileNotFoundException::new);
        boolean isEmailNull = visibilityChangeRequest.getEmailVisibility() == null;
        boolean isTgNull = visibilityChangeRequest.getTelegramVisibility() == null;
        if (isEmailNull && isTgNull) {
            return profileMapper.profileEntityToFullProfileResponse(entity);
        }
        if (!isEmailNull) {
            entity.setEmailVisibility(visibilityChangeRequest.getEmailVisibility());
        }
        if (!isTgNull) {
            entity.setTelegramVisibility(visibilityChangeRequest.getTelegramVisibility());
        }
        profileRepository.save(entity);
        return profileMapper.profileEntityToFullProfileResponse(entity);
    }
}
