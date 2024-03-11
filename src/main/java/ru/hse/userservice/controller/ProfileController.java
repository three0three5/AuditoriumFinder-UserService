package ru.hse.userservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hse.userservice.dto.request.ProfileChangeRequest;
import ru.hse.userservice.dto.request.VisibilityChangeRequest;
import ru.hse.userservice.dto.response.FullProfileResponse;

import static ru.hse.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Profiles API", description = "Операции над профилем авторизованного пользователя " +
        "и получения данных профилей других пользователей")
@RequestMapping("/user/profile")
public interface ProfileController {
    @Operation(summary = "Редактирование никнейма")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PatchMapping
    ResponseEntity<FullProfileResponse> editNickname(
            @Valid @RequestBody ProfileChangeRequest profileChangeRequest);

    @Operation(summary = "Получение профиля",
            description = "Позволяет получить поля пользователя в зависимости" +
                    "от его отношения к посылающему запрос пользователю")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/{id}")
    ResponseEntity<FullProfileResponse> getProfileData(@PathVariable int id);

    @Operation(summary = "Смена видимости полей",
            description = "Меняет видимость переданного поля " +
                    "(telegramVisibility - может иметь видимость private friends_only, public;" +
                    "emailVisibility - может иметь видимость private, friends_only, public;" +
                    "остальные поля профиля публичны всегда, кроме местоположения (ответственен" +
                    "AuditoriumService)")
    @PatchMapping("/visibility")
    ResponseEntity<FullProfileResponse> changeVisibility(
            @Valid @RequestBody VisibilityChangeRequest visibilityChangeRequest);
}
