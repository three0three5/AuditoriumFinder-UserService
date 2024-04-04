package ru.orobtsovv.userservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"from_id", "to_id"}),
        @UniqueConstraint(columnNames = {"to_id", "from_id"})})
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_id", referencedColumnName = "userid")
    private ProfileEntity from;

    @ManyToOne
    @JoinColumn(name = "to_id", referencedColumnName = "userid")
    private ProfileEntity to;
}
