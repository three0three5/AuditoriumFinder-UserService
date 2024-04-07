package ru.orobtsovv.userservice.dto.messages;

import lombok.Data;

@Data
public class AddTelegramMessage {
    private int userid;
    private String telegramHandle;
}
