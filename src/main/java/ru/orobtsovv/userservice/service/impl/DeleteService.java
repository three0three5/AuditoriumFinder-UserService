package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.repository.FriendRequestRepository;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.domain.repository.SubscribeRepository;

@Service
@RequiredArgsConstructor
public class DeleteService {
    private final FriendRequestRepository requestRepository;
    private final SubscribeRepository subscribeRepository;
    private final ProfileRepository profileRepository;

    @Transactional
    public void deleteAllInfo(int userid) {
        subscribeRepository.deleteAllSubscriptions(userid);
        requestRepository.deleteAllRequests(userid);
        profileRepository.deleteAllFriendLinks(userid);
        profileRepository.deleteById(userid);
    }
}
