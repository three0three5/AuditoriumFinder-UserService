package ru.orobtsovv.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.entity.RequestEntity;
import ru.orobtsovv.userservice.domain.entity.RequestEntityId;

import java.util.List;

public interface FriendRequestRepository extends JpaRepository<RequestEntity, RequestEntityId> {
    @Query("delete from RequestEntity r " +
            "where r.from.userid=:userid or " +
            "r.to.userid=:userid")
    @Transactional
    @Modifying
    int deleteAllRequests(int userid);

    @Query("select r.from from RequestEntity r " +
            "where r.to=:userid")
    List<ProfileEntity> findIncomingRequests(int userid);

    @Query("select r.to from RequestEntity r " +
            "where r.from=:userid")
    List<ProfileEntity> findOutgoingRequests(int userid);
}
