package ru.orobtsovv.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.RequestEntityId;
import ru.orobtsovv.userservice.domain.entity.SubscribeEntity;

public interface SubscribeRepository extends JpaRepository<SubscribeEntity, RequestEntityId> {
    @Query("delete from SubscribeEntity s " +
            "where s.to.userid=:userid or s.from.userid =:userid")
    @Modifying
    @Transactional
    int deleteAllSubscriptions(int userid);
}
