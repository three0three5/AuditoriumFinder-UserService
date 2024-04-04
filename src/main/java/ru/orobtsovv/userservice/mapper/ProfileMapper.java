package ru.orobtsovv.userservice.mapper;

import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.entity.TagEntity;
import ru.orobtsovv.userservice.dto.request.ProfileCreateRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.dto.response.TagResponse;

@Service
public class ProfileMapper {
    public FullProfileResponse profileEntityToFullProfileResponse(ProfileEntity entity) {
        return new FullProfileResponse()
                .setNickname(entity.getNickname())
                .setEmail(entity.getEmail())
                .setUserid(entity.getUserid())
                .setTelegramHandle(entity.getTelegramHandle())
                .setEmailVisibility(entity.getEmailVisibility())
                .setTelegramVisibility(entity.getTelegramVisibility())
                .setTags(entity.getTags().stream().map(this::tagEntityToTagResponse).toList());
    }

    public TagResponse tagEntityToTagResponse(TagEntity entity) {
        return new TagResponse()
                .setTagId(entity.getTagId())
                .setName(entity.getName())
                .setDescription(entity.getDescription());
    }

    public ProfileEntity profileCreateRequestToProfileEntity(ProfileCreateRequest request) {
        ProfileEntity entity = new ProfileEntity();
        entity.setTelegramHandle(request.getTelegramHandle());
        entity.setUserid(request.getId());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        return entity;
    }

    public FullProfileResponse profileEntityToFullProfileResponseFiltered(
            ProfileEntity entity, boolean areFriends) {
        return null; // TODO
    }
}
