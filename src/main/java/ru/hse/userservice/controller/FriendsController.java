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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hse.userservice.dto.response.ShortMessageResponse;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

import static ru.hse.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Friends API")
@RequestMapping("/friends/{userid}")
public interface FriendsController {
    @Operation(summary = "Получение списка всех друзей пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/")
    ResponseEntity<List<ShortUserResponse>> getFriendList(@PathVariable int userid);

    @Operation(summary = "Подписка на обновления пользователя с указанным id",
            description = "Если не является другом - ничего не происходит")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/{id}/subscribe")
    ResponseEntity<ShortMessageResponse> subscribeToNotificationsFromUser(
            @PathVariable int id,
            @PathVariable int userid);

    @Operation(summary = "Отмена подписки на обновления пользователя с указанным id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/{id}/unsubscribe")
    ResponseEntity<ShortMessageResponse> unsubscribeFromNotificationsFromUser(
            @PathVariable int id,
            @PathVariable int userid);

    @Operation(summary = "Удалить из друзей пользователя с указанным id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PatchMapping("/{id}/remove")
    ResponseEntity<ShortUserResponse> removeFromFriendList(
            @PathVariable int id,
            @PathVariable int userid);
}
