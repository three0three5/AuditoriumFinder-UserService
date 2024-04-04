package ru.orobtsovv.userservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.orobtsovv.userservice.domain.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, String> {
}
