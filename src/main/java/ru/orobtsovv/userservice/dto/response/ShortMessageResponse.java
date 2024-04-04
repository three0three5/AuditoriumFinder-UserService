package ru.orobtsovv.userservice.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ShortMessageResponse {
    private String message;
}
