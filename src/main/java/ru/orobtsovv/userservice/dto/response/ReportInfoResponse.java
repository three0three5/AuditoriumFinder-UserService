package ru.orobtsovv.userservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ReportInfoResponse {
    private long reportId;
    private int reportFromId;
    private int reportedUserId;
    private FullProfileResponse reportedUserProfile;
    private String reportDescription;
    private LocalDateTime reportTimestamp;
}
