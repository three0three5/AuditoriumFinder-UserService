package ru.orobtsovv.userservice.dto.messages;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileCreateRequest {
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    private Integer id;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String nickname;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String email;

    private String telegramHandle;
}
