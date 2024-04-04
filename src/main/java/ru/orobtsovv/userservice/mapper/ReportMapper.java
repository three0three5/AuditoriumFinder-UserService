package ru.orobtsovv.userservice.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.domain.entity.ReportEntity;
import ru.orobtsovv.userservice.dto.response.ReportInfoResponse;

@Service
@RequiredArgsConstructor
public class ReportMapper {
    private final ProfileMapper mapper;

    public ReportInfoResponse reportEntityToReportInfoResponse(ReportEntity reportEntity) {
        return new ReportInfoResponse()
                .setReportDescription(reportEntity.getDescription())
                .setReportFromId(reportEntity.getFromId())
                .setReportedUserId(reportEntity.getTo().getUserid())
                .setReportedUserProfile(mapper.profileEntityToFullProfileResponse(reportEntity.getTo()))
                .setReportTimestamp(reportEntity.getCreatedAt())
                .setReportId(reportEntity.getId());
    }
}
