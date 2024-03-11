package ru.hse.userservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.hse.userservice.model.FieldVisibility;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FullProfileResponse {
    private int userId;
    private String userNickname;
    private List<TagResponse> userTags;

    private String telegramHandler;
    private FieldVisibility telegramVisibility;

    private String email;
    private FieldVisibility emailVisibility;
}
