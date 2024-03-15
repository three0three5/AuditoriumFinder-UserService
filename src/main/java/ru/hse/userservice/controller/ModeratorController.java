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
import ru.hse.userservice.dto.response.BanInfoResponse;
import ru.hse.userservice.dto.response.FullProfileResponse;
import ru.hse.userservice.dto.response.ReportInfoResponse;
import ru.hse.userservice.dto.response.ShortUserResponse;

import java.util.List;

import static ru.hse.userservice.utils.constants.SwaggerConstants.SUCCESS;

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

    @Operation(summary = "Список банов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/banned")
    ResponseEntity<List<BanInfoResponse>> getListOfBannedUsers();

    @Operation(summary = "Отклонить репорт")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/reports/{moderatorId}/{id}/decline")
    ResponseEntity<ReportInfoResponse> declineReport(
            @PathVariable int moderatorId,
            @PathVariable int id);

    @Operation(summary = "Забанить пользователя",
            description = "Сервис должен взаимодействовать с AuthService, чтобы " +
                    "запретить пользователю доступ к аккаунту")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/{moderatorId}/{id}/ban")
    ResponseEntity<ShortUserResponse> banUser(
            @PathVariable int moderatorId,
            @PathVariable int id);

    @Operation(summary = "Удалить пользователя из забаненных",
            description = "Сервис должен взаимодействовать с AuthService")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @PostMapping("/{moderatorId}/{id}/cancel_ban")
    ResponseEntity<ShortUserResponse> removeUserFromBanned(
            @PathVariable int moderatorId,
            @PathVariable int id);

    @Operation(summary = "Получение профиля",
            description = "Позволяет получить все поля пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS)
    })
    @GetMapping("/{moderatorId}/{id}")
    ResponseEntity<FullProfileResponse> getProfileData(
            @PathVariable int moderatorId,
            @PathVariable int id);
}
