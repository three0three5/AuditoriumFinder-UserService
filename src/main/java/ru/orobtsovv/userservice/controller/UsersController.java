package ru.orobtsovv.userservice.controller;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.orobtsovv.userservice.dto.request.ReportRequest;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;

import java.util.List;

import static ru.orobtsovv.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Users API", description = "Общие операции над пользователями со стороны " +
        "текущего авторизованного пользователя")
@RequestMapping("/user")
public interface UsersController {
    @Operation(summary = "Поиск пользователей по критериям",
            description = "Позволяет найти пользователей по никнейму или набору тегов." +
                    "Теги должны быть представлены своими идентификаторами; " +
                    "Операция должна быть доступна модератору;" +
                    " БУДЕТ ЗАМЕНЕНО НА ВАРИАНТ С ПАГИНАЦИЕЙ!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/search")
    ResponseEntity<List<ShortUserResponse>> searchByCriteria(
            @RequestParam(value = "nickname", required = false) String nickname,
            @RequestParam(value = "tags", required = false) List<String> tagIds,
            @RequestParam(value = "id", required = false) Integer id);

    @Operation(summary = "Отправка жалобы на юзера",
            description = "Позволяет отправить репорт с предоставлением описания жалобы")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/{id}/report")
    ResponseEntity<ShortUserResponse> reportUser(
            @RequestHeader int userid,
            @Valid @RequestBody ReportRequest reportRequest,
            @PathVariable int id);
}
