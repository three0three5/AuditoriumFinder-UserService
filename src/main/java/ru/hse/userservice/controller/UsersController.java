package ru.hse.userservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hse.userservice.dto.request.ReportRequest;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

import static ru.hse.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Users API", description = "Общие операции над пользователями со стороны " +
        "текущего авторизованного пользователя")
@RequestMapping("/user/{userid}")
public interface UsersController {
    @Operation(summary = "Поиск пользователей по критериям",
            description = "Позволяет найти пользователей по никнейму или набору тегов." +
                    "Теги должны быть представлены своими идентификаторами; " +
                    "Операция должна быть доступна модератору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/search")
    ResponseEntity<List<ShortUserResponse>> searchByCriteria(
            @PathVariable int userid,
            @RequestParam("nickname") String nickname,
            @RequestParam("tags") List<String> tagIds);

    @Operation(summary = "Отправка жалобы на юзера",
            description = "Позволяет отправить репорт с предоставлением описания жалобы")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/{id}/report")
    ResponseEntity<ShortUserResponse> reportUser(
            @PathVariable int userid,
            @Valid @RequestBody ReportRequest reportRequest,
            @PathVariable int id);
}
