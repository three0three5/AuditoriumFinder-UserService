package ru.orobtsovv.userservice.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.orobtsovv.userservice.validator.ValidDate;

import java.time.LocalDateTime;

import static ru.orobtsovv.userservice.utils.constants.CommonConstants.DATE_PATTERN;

@Data
@NoArgsConstructor
public class BanRequest {
    private int userid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    @ValidDate
    private LocalDateTime bannedUntil;
    private String reason;
}
