package ru.orobtsovv.userservice.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.orobtsovv.userservice.controller.TagsController;
import ru.orobtsovv.userservice.dto.response.TagResponse;
import ru.orobtsovv.userservice.service.impl.TagService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagsControllerImpl implements TagsController {
    private final TagService tagService;

    @Override
    public ResponseEntity<List<TagResponse>> addTags(int userid, List<String> tagId) {
        return ResponseEntity.ok(tagService.addTags(userid, tagId));
    }

    @Override
    public ResponseEntity<List<TagResponse>> removeTags(int userid, List<String> tagId) {
        return ResponseEntity.ok(tagService.removeTags(userid, tagId));
    }

    @Override
    public ResponseEntity<List<TagResponse>> getListOfTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }
}
