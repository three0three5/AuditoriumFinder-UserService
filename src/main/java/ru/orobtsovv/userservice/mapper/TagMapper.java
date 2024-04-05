package ru.orobtsovv.userservice.mapper;

import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.domain.entity.TagEntity;
import ru.orobtsovv.userservice.dto.response.TagResponse;

@Service
public class TagMapper {
    public TagResponse tagEntityToTagResponse(TagEntity entity) {
        return new TagResponse()
                .setTagId(entity.getTagId())
                .setName(entity.getName())
                .setDescription(entity.getDescription());
    }
}
