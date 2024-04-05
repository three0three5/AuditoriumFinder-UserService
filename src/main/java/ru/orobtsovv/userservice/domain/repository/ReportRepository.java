package ru.orobtsovv.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ReportEntity;

import java.util.List;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    @Query("delete from ReportEntity r " +
            "where r.to=:userid")
    @Modifying
    @Transactional
    int deleteReports(int userid);

    @Query("select r from ReportEntity r " +
            "where r.deletedBy is null and r.id=:id")
    @Modifying
    @Transactional
    void delete(long id);

    List<ReportEntity> findAllByDeletedBy(Integer deletedBy);
}
