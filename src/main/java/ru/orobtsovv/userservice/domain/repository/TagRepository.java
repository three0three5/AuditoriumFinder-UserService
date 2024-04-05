package ru.orobtsovv.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.orobtsovv.userservice.domain.entity.TagEntity;

import java.util.Set;

public interface TagRepository extends JpaRepository<TagEntity, String> {
    @Query("select t from TagEntity t " +
            "where t.tagId in :ids")
    Set<TagEntity> findAllByIdSet(Iterable<String> ids);
}
