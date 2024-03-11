package ru.hse.userservice.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ShortUserResponse {
    private int userId;
    private String userNickname;
}
