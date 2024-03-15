package ru.hse.userservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hse.userservice.dto.response.TagResponse;

import java.util.List;

import static ru.hse.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Tags API")
@RequestMapping("/tags")
public interface TagsController {
    @Operation(summary = "Добавить тег(и) к профилю",
            description = "Теги должны быть представлены своими идентификаторами. " +
                    "Если тег уже есть, ничего не происходит")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/{userid}/add")
    ResponseEntity<List<TagResponse>> addTags(
            @PathVariable int userid,
            @RequestParam List<String> tagId);

    // TODO: изменить List<String> на более конкретную реализацию
    @Operation(summary = "Удалить тег(и) из профиля",
            description = "Теги должны быть представлены своими идентификаторами. " +
                    "Если тега в профиле нет, ничего не происходит")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/{userid}/remove")
    ResponseEntity<List<TagResponse>> removeTags(
            @PathVariable int userid,
            @RequestParam List<String> tagId);

    @Operation(summary = "Получить список всех тегов",
            description = "Предоставляет все существующие теги")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/")
    ResponseEntity<List<TagResponse>> getListOfTags();
}
