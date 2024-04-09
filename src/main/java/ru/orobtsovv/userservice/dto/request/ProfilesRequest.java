package ru.orobtsovv.userservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ProfilesRequest {
    private List<Integer> ids;
}
