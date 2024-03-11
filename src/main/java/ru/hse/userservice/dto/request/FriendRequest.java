package ru.hse.userservice.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FriendRequest {
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,
    name = "UserID", description = "ID пользователя, который отправил запрос")
    @NotNull
    private Integer fromUserId;
}
