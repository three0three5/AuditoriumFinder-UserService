package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.repository.ReportRepository;
import ru.orobtsovv.userservice.dto.request.BanRequest;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;

import static ru.orobtsovv.userservice.utils.constants.CommonConstants.DELETED_PROFILE_SUCCESS;

@Service
@RequiredArgsConstructor
public class BanService {
    private final DeleteService deleteService;
    private final MessageQueryService queryService;
    private final ReportRepository reportRepository;

    @Transactional
    public ShortMessageResponse ban(BanRequest request) {
        deleteService.deleteAllInfo(request.getUserid());
        reportRepository.deleteReports(request.getUserid());
        queryService.sendDeletedProfile(request);
        return new ShortMessageResponse(DELETED_PROFILE_SUCCESS);
    }
}
