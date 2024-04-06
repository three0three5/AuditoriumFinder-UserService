package ru.orobtsovv.userservice.domain;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.SetJoin;
import org.springframework.data.jpa.domain.Specification;
import ru.orobtsovv.userservice.domain.entity.ProfileEntity;
import ru.orobtsovv.userservice.domain.entity.TagEntity;

import java.util.List;

public class ProfileSpecifications {

    public static Specification<ProfileEntity> byAllParams(String nickname, List<String> tagIds, Integer id) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (nickname != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("nickname"), nickname));
            }

            if (tagIds != null && !tagIds.isEmpty()) {
                SetJoin<ProfileEntity, TagEntity> tagJoin = root.joinSet("tags");
                predicate = criteriaBuilder.and(predicate, tagJoin.get("tagId").in(tagIds));
            }

            if (id != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("userid"), id));
            }

            return predicate;
        };
    }
}
