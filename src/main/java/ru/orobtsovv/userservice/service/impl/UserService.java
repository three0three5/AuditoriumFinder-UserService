package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.ProfileSpecifications;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.mapper.ProfileMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper mapper;

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<ShortUserResponse> searchBy(String nickname, List<String> tagIds, Integer id) {
        log.info("search by: \nnickname: " + nickname + "\ntag ids: " + tagIds + "\nid: " + id);
        Specification<ProfileEntity> spec = ProfileSpecifications.byAllParams(nickname, tagIds, id);
        List<ProfileEntity> profiles = profileRepository.findAll(spec);
        return profiles.stream()
                .map(mapper::profileEntityToShortUserResponse)
                .toList();
    }
}
