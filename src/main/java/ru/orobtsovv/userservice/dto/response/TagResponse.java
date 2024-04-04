package ru.orobtsovv.userservice.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TagResponse {
    private String tagId;
    private String name;
    private String description;
}
