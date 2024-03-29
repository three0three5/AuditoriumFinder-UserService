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
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

import static ru.hse.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Friend Requests Controller", description = "API для авторизованного пользователя " +
        "и операций над его заявками в друзья")
@RequestMapping("/requests/{userid}")
public interface RequestsController {
    @Operation(summary = "Получение всех входящих заявок клиента")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/in")
    ResponseEntity<List<ShortUserResponse>> getIncomingRequests(@PathVariable int userid);

    @Operation(summary = "Получение всех исходящих заявок клиента")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/out")
    ResponseEntity<List<ShortUserResponse>> getOutgoingRequests(@PathVariable int userid);

    @Operation(summary = "Отправить заявку в друзья или принять запрос",
            description = "Принять запрос от " +
                    "указанного в пути id к userid. Если такой id не отправлял заявку, " +
                    "будет отправлен запрос, если такого id не существует - ничего не произойдет;" +
                    " в зависимости от существования id, возвращается тело добавленного пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/in/{id}/accept")
    ResponseEntity<ShortUserResponse> makeFriendRequest(
            @PathVariable int userid,
            @PathVariable int id);

    @Operation(summary = "Отклонить запрос в друзья", description = "Логика подобна" +
            "предыдущему методу. Запрос от id к userid (входящая)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/in/{id}/decline")
    ResponseEntity<ShortUserResponse> declineIncomingRequestFromUser(
            @PathVariable int userid,
            @PathVariable int id);

    @Operation(summary = "Отклонить запрос в друзья", description = "Отменить запрос в друзья" +
            "от userid к id (исходящую)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/out/{id}/remove")
    ResponseEntity<ShortUserResponse> removeOutgoingRequest(
            @PathVariable int userid,
            @PathVariable int id);
}
