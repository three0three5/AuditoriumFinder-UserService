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
import ru.orobtsovv.userservice.dto.request.BanRequest;
import ru.orobtsovv.userservice.dto.response.FullProfileResponse;
import ru.orobtsovv.userservice.dto.response.ReportInfoResponse;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;

import java.util.List;

import static ru.orobtsovv.userservice.utils.constants.SwaggerConstants.SUCCESS;

@Tag(name = "Moderator API", description = "API для модераторов. " +
        "У модераторов нет профиля, но есть идентификатор. " +
        "Это позволяет соотносить действия с тем, кто их сделал")
@RequestMapping("/moderator")
public interface ModeratorController {
    @Operation(summary = "Список репортов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/reports")
    ResponseEntity<List<ReportInfoResponse>> getListOfReportedUsers();

    @Operation(summary = "Отклонить репорт с определенным id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/reports/{id}/decline")
    ResponseEntity<ShortMessageResponse> declineReport(
            @RequestHeader(name = "userid") int userid,
            @PathVariable long id);

    @Operation(summary = "Забанить пользователя",
            description = "Сервис должен взаимодействовать с AuthService, чтобы " +
                    "запретить пользователю доступ к аккаунту. Помимо этого, все заявки пользователя и" +
                    " его местоположения, а также профиль должны быть удалены. Метод асинхронно " +
                    "рассылает сообщение об удалении через брокер сообщений остальным сервисам.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/ban")
    ResponseEntity<ShortMessageResponse> banUser(
            @RequestHeader(name = "userid") int userid,
            @Valid @RequestBody BanRequest banRequest);

    @Operation(summary = "Получение профиля",
            description = "Позволяет получить все поля пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/{id}")
    ResponseEntity<FullProfileResponse> getProfileData(
            @PathVariable int id);
}
