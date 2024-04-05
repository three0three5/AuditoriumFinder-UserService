package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.entity.TagEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.domain.repository.TagRepository;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.mapper.ProfileMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ProfileRepository profileRepository;
    private final TagRepository tagRepository;
    private final ProfileMapper mapper;

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<ShortUserResponse> searchBy(String nickname, List<String> tagIds, Integer id) {
        List<ShortUserResponse> result = new ArrayList<>();
        if (id != null) {
            Optional<ProfileEntity> entityOptional = profileRepository.findById(id);
            if (entityOptional.isEmpty()) return result;
            result.add(mapper.profileEntityToShortUserResponse(entityOptional.get()));
            return result;
        }
        if (nickname != null && tagIds != null) {
            Set<TagEntity> tags = new HashSet<>(tagRepository.findAllById(tagIds));
            List<ProfileEntity> entities = profileRepository.findByNicknameAndTags(nickname, tags);
            result.addAll(entities.stream().map(mapper::profileEntityToShortUserResponse).toList());
            return result;
        }
        if (nickname == null && (tagIds == null || tagIds.isEmpty())) {
            return profileRepository.findAll().stream()
                    .map(mapper::profileEntityToShortUserResponse).toList();
        }
        return result;
    }
}
