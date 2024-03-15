package ru.hse.userservice.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.userservice.controller.TagsController;
import ru.hse.userservice.dto.response.TagResponse;

import java.util.List;

@RestController
public class TagsControllerImpl implements TagsController {
    @Override
    public ResponseEntity<List<TagResponse>> addTags(int userid, List<String> tagId) {
        return null;
    }

    @Override
    public ResponseEntity<List<TagResponse>> removeTags(int userid, List<String> tagId) {
        return null;
    }

    @Override
    public ResponseEntity<List<TagResponse>> getListOfTags() {
        return null;
    }
}
