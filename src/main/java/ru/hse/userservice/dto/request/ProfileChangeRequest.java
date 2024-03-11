package ru.hse.userservice.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfileChangeRequest {
    @NotBlank
    private String nickname;
}
