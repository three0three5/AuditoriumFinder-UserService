package ru.orobtsovv.userservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@IdClass(RequestEntityId.class)
public class RequestEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "from_id", referencedColumnName = "userid")
    private ProfileEntity from;

    @Id
    @ManyToOne
    @JoinColumn(name = "to_id", referencedColumnName = "userid")
    private ProfileEntity to;
}
