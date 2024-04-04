package ru.orobtsovv.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.RequestEntity;

public interface FriendRequestRepository extends JpaRepository<RequestEntity, Long> {
    @Query("delete from RequestEntity r " +
            "where r.from.userid=:userid or " +
            "r.to.userid=:userid")
    @Transactional
    @Modifying
    int deleteAllRequests(int userid);
}
