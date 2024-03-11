package ru.hse.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hse.userservice.dto.response.TagResponse;

import java.util.List;

@RequestMapping("/user/profile/{id}/tags")
public interface TagsController {
    @PatchMapping
    ResponseEntity<List<TagResponse>> addTag();

    @PatchMapping
    ResponseEntity<List<TagResponse>> removeTag();

    @GetMapping
    ResponseEntity<List<TagResponse>> getListOfTags();
}
