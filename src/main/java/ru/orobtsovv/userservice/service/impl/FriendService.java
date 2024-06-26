package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.dto.messages.FriendDeleteMessage;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.eventlistener.event.FriendDeleteEvent;
import ru.orobtsovv.userservice.exception.NotFoundException;
import ru.orobtsovv.userservice.exception.ProfileNotFoundException;
import ru.orobtsovv.userservice.mapper.ProfileMapper;

import java.util.List;
import java.util.Set;

import static ru.orobtsovv.userservice.utils.constants.CommonConstants.FRIEND_REMOVED;
import static ru.orobtsovv.userservice.utils.constants.ExceptionConstants.FRIEND_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class FriendService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper mapper;
    private final ApplicationEventPublisher eventPublisher;

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
        boolean removed = first.getFriends().remove(second);
        if (!removed) throw new NotFoundException(FRIEND_NOT_FOUND.formatted(second.getNickname()));
        log.info("removed from first: " + removed);
        removed = second.getFriends().remove(first);
        log.info("removed: " + removed);
        profileRepository.save(first);
        profileRepository.save(second);

        var message = new FriendDeleteMessage(userid, id);
        eventPublisher.publishEvent(new FriendDeleteEvent(this, message));

        return new ShortMessageResponse(FRIEND_REMOVED.formatted(second.getNickname()));
    }

    public Boolean areFriends(int id1, int id2) {
        return profileRepository.areFriends(id1, id2);
    }
}
