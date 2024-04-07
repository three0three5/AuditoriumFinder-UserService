package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.dto.request.ProfileChangeRequest;
import ru.orobtsovv.userservice.dto.messages.ProfileCreateRequest;
import ru.orobtsovv.userservice.dto.request.VisibilityChangeRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.exception.ProfileNotFoundException;
import ru.orobtsovv.userservice.mapper.ProfileMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public void createProfile(ProfileCreateRequest profileCreateRequest) {
        ProfileEntity entity = profileMapper.profileCreateRequestToProfileEntity(profileCreateRequest);
        profileRepository.save(entity);
    }


    public void removeTelegram(int userid) {
        ProfileEntity entity = profileRepository.findById(userid).orElseThrow(ProfileNotFoundException::new);
        entity.setTelegramHandle(null);
        profileRepository.save(entity);
    }

    public void addTelegram(int userid, String telegramHandle) {
        ProfileEntity entity = profileRepository.findById(userid).orElseThrow(ProfileNotFoundException::new);
        entity.setTelegramHandle(telegramHandle);
        profileRepository.save(entity);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public FullProfileResponse getFullProfile(int id) {
        ProfileEntity entity = profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new);
        return profileMapper.profileEntityToFullProfileResponse(entity);
    }

    @Transactional
    public FullProfileResponse editNickname(int userid, ProfileChangeRequest profileChangeRequest) {
        ProfileEntity entity = profileRepository.findById(userid).orElseThrow(ProfileNotFoundException::new);
        entity.setNickname(profileChangeRequest.getNickname());
        profileRepository.save(entity);
        return profileMapper.profileEntityToFullProfileResponse(entity);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public FullProfileResponse getFilteredProfile(int userid, Integer id) {
        if (id == null || id.equals(userid)) {
            ProfileEntity entity = profileRepository.findById(userid)
                    .orElseThrow(ProfileNotFoundException::new);
            return profileMapper.profileEntityToFullProfileResponse(entity);
        }
        ProfileEntity entity = profileRepository.findById(id)
                .orElseThrow(ProfileNotFoundException::new);
        boolean areFriends = profileRepository.areFriends(userid, id);
        return profileMapper.profileEntityToFullProfileResponseFiltered(entity, areFriends);
    }

    @Transactional
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
