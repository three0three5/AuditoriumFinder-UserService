package ru.hse.userservice.dto.request;

import lombok.Data;
import ru.hse.userservice.model.FieldVisibility;

@Data
public class VisibilityChangeRequest {
    private FieldVisibility telegramVisibility;
    private FieldVisibility emailVisibility;
}
