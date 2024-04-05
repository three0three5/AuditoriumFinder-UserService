package ru.orobtsovv.userservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.orobtsovv.userservice.dto.request.ProfileCreateRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;

import static ru.orobtsovv.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Account Changes API", description = "API, предназначенное " +
        "исключительно для AuthService для поддержки консистентности данных " +
        "об аккаунте и профиле. Api Gateway ни в коем случае не должен пересылать " +
        "сюда запросы")
@RequestMapping("/account")
public interface AccountChangeController {
    @Operation(summary = "Создание профиля",
            description = "Выполняется сразу после создания аккаунта. У модераторов профилей нет")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = SUCCESS)
    })
    @PostMapping
    ResponseEntity<FullProfileResponse> createProfile(
            @Valid @RequestBody ProfileCreateRequest profileCreateRequest);

    @Operation(summary = "Удаление телеграма",
            description = "Удаляет из профиля запись о телеграме")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @DeleteMapping("/{userid}/tg")
    ResponseEntity<FullProfileResponse> removeTelegram(@PathVariable int userid);

    @Operation(summary = "Добавление телеграма",
            description = "Добавляет в профиль запись о телеграме (видимость по умолчанию private)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PatchMapping("/{userid}/tg")
    ResponseEntity<FullProfileResponse> addTelegram(
            @PathVariable int userid,
            @RequestParam(name = "telegram_handle") String telegramHandle);
}
