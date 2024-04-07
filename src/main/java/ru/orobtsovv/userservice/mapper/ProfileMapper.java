package ru.orobtsovv.userservice.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.dto.messages.ProfileCreateRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.model.FieldVisibility;

@Service
@RequiredArgsConstructor
public class ProfileMapper {
    private final TagMapper tagMapper;

    public FullProfileResponse profileEntityToFullProfileResponse(ProfileEntity entity) {
        return new FullProfileResponse()
                .setNickname(entity.getNickname())
                .setEmail(entity.getEmail())
                .setUserid(entity.getUserid())
                .setTelegramHandle(entity.getTelegramHandle())
                .setEmailVisibility(entity.getEmailVisibility())
                .setTelegramVisibility(entity.getTelegramVisibility())
                .setTags(entity.getTags().stream().map(tagMapper::tagEntityToTagResponse).toList());
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
        FieldVisibility email = entity.getEmailVisibility();
        FieldVisibility tg = entity.getTelegramVisibility();
        FullProfileResponse response = new FullProfileResponse()
                .setNickname(entity.getNickname())
                .setUserid(entity.getUserid())
                .setEmailVisibility(email)
                .setTelegramVisibility(tg)
                .setTags(entity.getTags().stream().map(tagMapper::tagEntityToTagResponse).toList())
                .setIsFriend(areFriends);
        if (FieldVisibility.PUBLIC.equals(email) ||
                FieldVisibility.FRIENDS_ONLY.equals(email) && areFriends) {
            response.setEmail(entity.getEmail());
        }
        if (FieldVisibility.PUBLIC.equals(tg) ||
                FieldVisibility.FRIENDS_ONLY.equals(tg) && areFriends) {
            response.setTelegramHandle(entity.getTelegramHandle());
        }
        return response;
    }

    public ShortUserResponse profileEntityToShortUserResponse(ProfileEntity profileEntity) {
        return new ShortUserResponse()
                .setUserid(profileEntity.getUserid())
                .setUserNickname(profileEntity.getNickname());
    }
}
