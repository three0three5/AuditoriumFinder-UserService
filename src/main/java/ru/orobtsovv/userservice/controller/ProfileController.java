package ru.orobtsovv.userservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.orobtsovv.userservice.dto.request.ProfileChangeRequest;
import ru.orobtsovv.userservice.dto.request.VisibilityChangeRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;

import java.util.List;
import java.util.Map;

import static ru.orobtsovv.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Profiles API", description = "Операции над профилем авторизованного пользователя " +
        "и получения данных профилей других пользователей")
@RequestMapping("/profile")
public interface ProfileController {
    @Operation(summary = "Редактирование никнейма")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PatchMapping("/")
    ResponseEntity<FullProfileResponse> editNickname(
            @RequestHeader int userid,
            @Valid @RequestBody ProfileChangeRequest profileChangeRequest);

    @Operation(summary = "Получение профиля",
            description = "Позволяет получить поля пользователя в зависимости" +
                    "от его отношения к посылающему запрос пользователю. Если id в пути не передан, " +
                    "будет возвращен собственный профиль пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping
    ResponseEntity<FullProfileResponse> getProfileData(
            @RequestHeader int userid,
            @RequestParam(required = false, name = "id") Integer id);

    @Operation(summary = "Смена видимости полей",
            description = "Меняет видимость переданного поля " +
                    "(telegramVisibility - может иметь видимость private friends_only, public;" +
                    "emailVisibility - может иметь видимость private, friends_only, public;" +
                    "остальные поля профиля публичны всегда, кроме местоположения (ответственен" +
                    "AuditoriumService)")
    @PatchMapping("/visibility")
    ResponseEntity<FullProfileResponse> changeVisibility(
            @RequestHeader int userid,
            @Valid @RequestBody VisibilityChangeRequest visibilityChangeRequest);

    @Operation(summary = "Получить по списку id список полных профилей",
            description = "Вид профилей зависит от наличия пользователя в списке друзей " +
                    "того пользователя, который отправляет запрос")
    @GetMapping("/listed")
    ResponseEntity<Map<Integer, FullProfileResponse>> mapIntToProfiles(
            @RequestHeader(name = "userid") int userid,
            @RequestParam List<Integer> ids);
}
