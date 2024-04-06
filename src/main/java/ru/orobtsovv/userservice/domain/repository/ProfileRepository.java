package ru.orobtsovv.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer>, JpaSpecificationExecutor<ProfileEntity> {
    @Query("select count(p) > 0 from ProfileEntity p " +
            "join p.friends f " +
            "where p.userid=:userid and f.userid=:id")
    boolean areFriends(int userid, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM friends_link " +
            "WHERE linked1=:userid OR linked2=:userid", nativeQuery = true)
    int deleteAllFriendLinks(int userid);
}
