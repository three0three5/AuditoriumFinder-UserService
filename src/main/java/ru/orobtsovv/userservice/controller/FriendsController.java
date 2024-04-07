package ru.orobtsovv.userservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;

import java.util.List;

import static ru.orobtsovv.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Friends API")
@RequestMapping("/friends")
public interface FriendsController {
    @Operation(summary = "Получение списка всех друзей пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/")
    ResponseEntity<List<ShortUserResponse>> getFriendList(@RequestHeader int userid);

    @Operation(summary = "Удалить из друзей пользователя с указанным id",
            description = "Если пользователя нет в списках друзей, вернется 404")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PatchMapping("/{id}/remove")
    ResponseEntity<ShortMessageResponse> removeFromFriendList(
            @PathVariable int id,
            @RequestHeader int userid);

    @Operation(summary = "Являются ли пользователи друзьями",
            description = "Для NotificationService; Gateway не должен перенаправлять сюда запросы")
    @GetMapping
    ResponseEntity<Boolean> areFriends(
            @RequestParam(name = "id1") int id1,
            @RequestParam(name = "id2") int id2);
}
