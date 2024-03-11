package ru.hse.userservice.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class ReportRequest {
    @NotNull
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer fromUserId;

    private String description;
}
