package ru.orobtsovv.userservice.dto.request;

import lombok.Data;
import ru.orobtsovv.userservice.model.FieldVisibility;

@Data
public class VisibilityChangeRequest {
    private FieldVisibility telegramVisibility;
    private FieldVisibility emailVisibility;
}
