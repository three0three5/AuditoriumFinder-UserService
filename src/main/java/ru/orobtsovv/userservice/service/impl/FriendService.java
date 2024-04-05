package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.exception.ProfileNotFoundException;
import ru.orobtsovv.userservice.mapper.ProfileMapper;

import java.util.List;
import java.util.Set;

import static ru.orobtsovv.userservice.utils.constants.CommonConstants.FRIEND_REMOVED;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper mapper;

    @Transactional(readOnly = true)
    public List<ShortUserResponse> getFriendList(int userid) {
        Set<ProfileEntity> friends = profileRepository
                .findById(userid)
                .orElseThrow(ProfileNotFoundException::new)
                .getFriends();
        return friends.stream().map(mapper::profileEntityToShortUserResponse).toList();
    }

    @Transactional
    public ShortMessageResponse removeFriend(int userid, int id) {
        ProfileEntity first = profileRepository.findById(userid).orElseThrow(ProfileNotFoundException::new);
        ProfileEntity second = profileRepository.findById(id).orElseThrow(ProfileNotFoundException::new);
        first.getFriends().remove(second);
        second.getFriends().remove(first);
        profileRepository.save(first);
        profileRepository.save(second);
        return new ShortMessageResponse(FRIEND_REMOVED.formatted(second.getNickname()));
    }
}
