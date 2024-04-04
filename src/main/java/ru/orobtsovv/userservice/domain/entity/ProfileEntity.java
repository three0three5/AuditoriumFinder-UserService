package ru.orobtsovv.userservice.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.orobtsovv.userservice.model.FieldVisibility;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProfileEntity {
    @Id
    @Column(name = "userid")
    private int userid;

    @Column(nullable = false)
    private String nickname;

    @Column(name = "tg_handle")
    private String telegramHandle;

    @Column
    private String email;

    @Column(name = "tg_visibility")
    private FieldVisibility telegramVisibility = FieldVisibility.PRIVATE;

    @Column(name = "email_visibility")
    private FieldVisibility emailVisibility = FieldVisibility.PRIVATE;

    @ManyToMany
    @JoinTable(name = "profile_tag",
            joinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tag_id"))
    private Set<TagEntity> tags = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "friends_link",
            joinColumns = @JoinColumn(name = "linked1", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name = "linked2", referencedColumnName = "userid"))
    private Set<ProfileEntity> friends = new HashSet<>();
}
