package ru.orobtsovv.userservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.orobtsovv.userservice.dto.response.TagResponse;

import java.util.List;

import static ru.orobtsovv.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Tags API")
@RequestMapping("/tags")
public interface TagsController {
    @Operation(summary = "Добавить тег(и) к профилю",
            description = "Теги должны быть представлены своими идентификаторами. " +
                    "Если тег уже есть, ничего не происходит")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/add")
    ResponseEntity<List<TagResponse>> addTags(
            @RequestHeader int userid,
            @RequestParam List<String> tagId);

    // TODO: изменить List<String> на более конкретную реализацию
    @Operation(summary = "Удалить тег(и) из профиля",
            description = "Теги должны быть представлены своими идентификаторами. " +
                    "Если тега в профиле нет, ничего не происходит")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/remove")
    ResponseEntity<List<TagResponse>> removeTags(
            @RequestHeader int userid,
            @RequestParam List<String> tagId);

    @Operation(summary = "Получить список всех тегов",
            description = "Предоставляет все существующие теги системы")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/")
    ResponseEntity<List<TagResponse>> getListOfTags();
}
