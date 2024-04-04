package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.entity.TagEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.domain.repository.TagRepository;
import ru.orobtsovv.userservice.dto.response.TagResponse;
import ru.orobtsovv.userservice.exception.ProfileNotFoundException;
import ru.orobtsovv.userservice.mapper.TagMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final ProfileRepository profileRepository;
    private final TagMapper tagMapper;

    public List<TagResponse> addTags(int userid, List<String> tagIds) {
        ProfileEntity entity = profileRepository.findById(userid)
                .orElseThrow(ProfileNotFoundException::new);
        List<TagEntity> toAdd = tagRepository.findAllById(tagIds);
        entity.getTags().addAll(toAdd);
        profileRepository.save(entity);
        return entity.getTags().stream().map(tagMapper::tagEntityToTagResponse).toList();
    }

    public List<TagResponse> removeTags(int userid, List<String> tagIds) {
        ProfileEntity entity = profileRepository.findById(userid)
                .orElseThrow(ProfileNotFoundException::new);
        List<TagEntity> toRemove = tagRepository.findAllById(tagIds);
        entity.getTags().removeAll(toRemove);
        profileRepository.save(entity);
        return entity.getTags().stream().map(tagMapper::tagEntityToTagResponse).toList();
    }

    public List<TagResponse> getAllTags() {
        return tagRepository.findAll().stream().map(tagMapper::tagEntityToTagResponse).toList();
    }
}
