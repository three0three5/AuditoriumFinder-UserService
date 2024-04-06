package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.entity.TagEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.domain.repository.TagRepository;
import ru.orobtsovv.userservice.dto.response.TagResponse;
import ru.orobtsovv.userservice.exception.ProfileNotFoundException;
import ru.orobtsovv.userservice.mapper.TagMapper;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class TagService {
    private final TagRepository tagRepository;
    private final ProfileRepository profileRepository;
    private final TagMapper tagMapper;

    @Transactional
    public List<TagResponse> addTags(int userid, List<String> tagIds) {
        ProfileEntity entity = profileRepository.findById(userid)
                .orElseThrow(ProfileNotFoundException::new);
        List<TagEntity> toAdd = tagRepository.findAllById(tagIds);
        log.info("to add %d".formatted(toAdd.size()));
        entity.getTags().addAll(toAdd);
        profileRepository.save(entity);
        return entity.getTags().stream().map(tagMapper::tagEntityToTagResponse).toList();
    }

    @Transactional
    public List<TagResponse> removeTags(int userid, List<String> tagIds) {
        ProfileEntity entity = profileRepository.findById(userid)
                .orElseThrow(ProfileNotFoundException::new);
        Set<TagEntity> toRemove = tagRepository.findAllByIdSet(tagIds);
        log.info("to remove %d".formatted(toRemove.size()));
        entity.getTags().removeAll(toRemove);
        profileRepository.save(entity);
        return entity.getTags().stream().map(tagMapper::tagEntityToTagResponse).toList();
    }

    public List<TagResponse> getAllTags() { // TODO пагинация
        return tagRepository.findAll().stream().map(tagMapper::tagEntityToTagResponse).toList();
    }
}
