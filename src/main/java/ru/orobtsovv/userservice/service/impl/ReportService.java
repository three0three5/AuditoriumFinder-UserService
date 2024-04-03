package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import ru.orobtsovv.userservice.dto.request.ReportRequest;
import ru.orobtsovv.userservice.dto.response.ReportInfoResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    public List<ReportInfoResponse> getAllReports() { // TODO пагинация
        throw new NotImplementedException();
    }

    public ReportInfoResponse declineReport(int moderatorId, int id) {
        return null;
    }

    public ShortUserResponse makeReport(int userid, ReportRequest reportRequest, int id) {
        return null;
    }
}
