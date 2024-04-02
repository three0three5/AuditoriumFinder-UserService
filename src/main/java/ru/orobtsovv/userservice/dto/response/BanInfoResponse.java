package ru.orobtsovv.userservice.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class BanInfoResponse {
    private int userId;
    private LocalDateTime bannedTimestamp;
    private LocalDateTime bannedUntil;
}
