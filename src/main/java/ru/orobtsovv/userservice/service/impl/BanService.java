package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.repository.ReportRepository;
import ru.orobtsovv.userservice.dto.messages.ProfileDeleteMessage;
import ru.orobtsovv.userservice.dto.request.BanRequest;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;

import static ru.orobtsovv.userservice.utils.constants.CommonConstants.DELETED_PROFILE_SUCCESS;

@Service
@RequiredArgsConstructor
@Slf4j
public class BanService {
    private final DeleteService deleteService;
    private final MessageQueryService queryService;
    private final ReportRepository reportRepository;

    @Transactional
    public ShortMessageResponse ban(int moderatorId, BanRequest request) {
        deleteService.deleteAllInfo(request.getUserid());
        int affected = reportRepository.deleteReports(request.getUserid());
        log.info("affected %d report rows".formatted(affected));
        ProfileDeleteMessage event = mapFromBanRequest(moderatorId, request);
        queryService.sendDeletedProfile(event);
        return new ShortMessageResponse(DELETED_PROFILE_SUCCESS.formatted(request.getUserid()));
    }

    private ProfileDeleteMessage mapFromBanRequest(int moderatorId, BanRequest request) {
        return new ProfileDeleteMessage()
                .setModeratorId(moderatorId)
                .setBannedUntil(request.getBannedUntil())
                .setUserid(request.getUserid())
                .setReason(request.getReason());
    }
}
