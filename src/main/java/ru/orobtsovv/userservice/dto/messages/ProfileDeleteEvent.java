package ru.orobtsovv.userservice.dto.messages;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ProfileDeleteEvent {
    private int userid;
    private int moderatorId;
    private LocalDateTime bannedUntil;
    private String reason;
}
