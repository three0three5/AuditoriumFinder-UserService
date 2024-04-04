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
        profileRepository.deleteById(userid); // TODO проверить что friends link удаляется
        /*
        TODO
        1. удаление аккаунта у AuthService
        2. удаление уведомлений у NotificationService
        3. удаление местоположений у AudService
         */
    }
}
