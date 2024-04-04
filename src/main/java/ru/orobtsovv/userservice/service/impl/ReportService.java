package ru.orobtsovv.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.entity.ReportEntity;
import ru.orobtsovv.userservice.domain.repository.ProfileRepository;
import ru.orobtsovv.userservice.domain.repository.ReportRepository;
import ru.orobtsovv.userservice.dto.request.ReportRequest;
import ru.orobtsovv.userservice.dto.response.ReportInfoResponse;
import ru.orobtsovv.userservice.dto.response.ShortMessageResponse;
import ru.orobtsovv.userservice.dto.response.ShortUserResponse;
import ru.orobtsovv.userservice.exception.ProfileNotFoundException;
import ru.orobtsovv.userservice.mapper.ReportMapper;

import java.util.List;

import static ru.orobtsovv.userservice.utils.constants.CommonConstants.REPORT_REMOVED;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {
    private final ReportRepository repository;
    private final ProfileRepository profileRepository;
    private final ReportMapper mapper;

    public List<ReportInfoResponse> getAllReports() { // TODO пагинация
        return repository.findAllByDeletedBy(null).stream()
                .map(mapper::reportEntityToReportInfoResponse).toList();
    }

    public ShortMessageResponse declineReport(int moderatorId, long id) {
        log.info(moderatorId + " is declining report " + id);
        repository.delete(id);
        return new ShortMessageResponse()
                .setMessage(REPORT_REMOVED);
    }

    @Transactional
    public ShortUserResponse makeReport(int userid, ReportRequest reportRequest, int id) {
        ReportEntity entity = new ReportEntity();
        ProfileEntity reported = profileRepository.findById(id)
                .orElseThrow(ProfileNotFoundException::new);
        entity.setTo(reported);
        entity.setDescription(reportRequest.getDescription());
        entity.setFromId(userid);
        repository.save(entity);
        return new ShortUserResponse()
                .setUserid(id)
                .setUserNickname(reported.getNickname());
    }
}
