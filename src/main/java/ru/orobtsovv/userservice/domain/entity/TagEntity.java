package ru.orobtsovv.userservice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TagEntity {
    @Id
    @Column(name = "tag_id")
    private String tagId;

    @Column
    private String name;

    @Column
    private String description;
}
