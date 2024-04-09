package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.entity.RequestEntity;
import ru.orobtsovv.userservice.domain.entity.RequestEntityId;
import ru.orobtsovv.userservice.domain.repository.FriendRequestRepository;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.dto.messages.FriendRequestAcceptedMessage;
import ru.orobtsovv.userservice.dto.messages.FriendRequestReceivedMessage;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.eventlistener.event.FriendAcceptEvent;
import ru.orobtsovv.userservice.eventlistener.event.FriendRequestReceivedEvent;
import ru.orobtsovv.userservice.exception.FriendsAlreadyException;
import ru.orobtsovv.userservice.exception.ProfileNotFoundException;
import ru.orobtsovv.userservice.exception.RequestNotFoundException;
import ru.orobtsovv.userservice.mapper.ProfileMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendRequestService {
    private final FriendRequestRepository requestRepository;
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final ApplicationEventPublisher eventPublisher;

    public List<ShortUserResponse> getIncomingRequests(int userid) {
        List<ProfileEntity> incomingRequests = requestRepository.findIncomingRequests(userid);
        return incomingRequests.stream().map(profileMapper::profileEntityToShortUserResponse).toList();
    }

    public List<ShortUserResponse> getOutgoingRequests(int userid) {
        List<ProfileEntity> outgoingRequests = requestRepository.findOutgoingRequests(userid);
        return outgoingRequests.stream().map(profileMapper::profileEntityToShortUserResponse).toList();
    }

    @Transactional
    public ShortUserResponse makeRequest(int from, int to) {
        if (profileRepository.areFriends(from, to)) throw new FriendsAlreadyException();
        RequestEntityId opposite = new RequestEntityId(to, from);
        ProfileEntity first = profileRepository.findById(from).orElseThrow(ProfileNotFoundException::new);
        ProfileEntity second = profileRepository.findById(to).orElseThrow(ProfileNotFoundException::new);
        if (requestRepository.existsById(opposite)) {
            requestRepository.deleteById(opposite);
            first.getFriends().add(second);
            second.getFriends().add(first);
            profileRepository.save(first);
            profileRepository.save(second);
            var message = new FriendRequestAcceptedMessage(to, from);
            eventPublisher.publishEvent(new FriendAcceptEvent(this, message));
        } else {
            RequestEntity entity = new RequestEntity();
            entity.setFrom(first);
            entity.setTo(second);
            requestRepository.save(entity);
            var message = new FriendRequestReceivedMessage(to, from);
            eventPublisher.publishEvent(new FriendRequestReceivedEvent(this, message));
        }
        return profileMapper.profileEntityToShortUserResponse(second);
    }

    @Transactional
    public ShortUserResponse deleteRequest(int from, int to, boolean isIncoming) {
        RequestEntityId id = new RequestEntityId(from, to);
        if (!requestRepository.existsById(id)) throw new RequestNotFoundException();
        requestRepository.deleteById(id);
        ProfileEntity toReturn;
        if (isIncoming) {
            toReturn = profileRepository.findById(from).orElseThrow(ProfileNotFoundException::new);
        } else {
            toReturn = profileRepository.findById(to).orElseThrow(ProfileNotFoundException::new);
        }
        return profileMapper.profileEntityToShortUserResponse(toReturn);
    }
}
