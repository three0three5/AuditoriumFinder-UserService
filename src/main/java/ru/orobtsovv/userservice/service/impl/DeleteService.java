package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.repository.FriendRequestRepository;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.domain.repository.SubscribeRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteService {
    private final FriendRequestRepository requestRepository;
    private final SubscribeRepository subscribeRepository;
    private final ProfileRepository profileRepository;

    @Transactional
    public void deleteAllInfo(int userid) {
        int affected = subscribeRepository.deleteAllSubscriptions(userid);
        log.info("affected %d subscribe rows".formatted(affected));
        affected = requestRepository.deleteAllRequests(userid);
        log.info("affected %d request rows".formatted(affected));
        affected = profileRepository.deleteAllFriendLinks(userid);
        log.info("affected %d friend link rows".formatted(affected));
        profileRepository.deleteById(userid);
    }
}
