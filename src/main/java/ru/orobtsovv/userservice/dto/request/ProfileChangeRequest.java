package ru.orobtsovv.userservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfileChangeRequest {
    @NotBlank
    private String nickname;
}
