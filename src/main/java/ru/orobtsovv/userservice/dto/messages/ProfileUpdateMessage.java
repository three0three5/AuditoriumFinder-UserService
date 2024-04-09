package ru.orobtsovv.userservice.dto.messages;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProfileUpdateMessage {
    private int userid;
    private String oldNickname;
    private String newNickname;
}
