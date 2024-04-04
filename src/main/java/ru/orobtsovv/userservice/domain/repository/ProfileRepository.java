package ru.orobtsovv.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {
    @Query("select (1) from ProfileEntity p " +
            "join p.friends f " +
            "where p.userid=:userid and f.userid=:id")
    boolean areFriends(int userid, int id);
}
