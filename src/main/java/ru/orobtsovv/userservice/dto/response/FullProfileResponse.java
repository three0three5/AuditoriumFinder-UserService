package ru.orobtsovv.userservice.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.orobtsovv.userservice.model.FieldVisibility;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FullProfileResponse {
    private int userid;
    private String nickname;
    private List<TagResponse> tags;

    private String telegramHandle;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private FieldVisibility telegramVisibility;

    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private FieldVisibility emailVisibility;

    private Boolean isFriend;
}
