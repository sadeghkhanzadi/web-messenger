package com.khanzadi.webMessenger.modules.sql.memeberShips.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.khanzadi.webMessenger.modules.sql.users.entity.UsersModel;
import com.khanzadi.webMessenger.modules.sql.groups.entity.GroupsModel;
import com.khanzadi.webMessenger.modules.sql.roles.entity.RolesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MemberShips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userInviterToGroupId;
    private Boolean enabled;

    @ManyToOne
    private UsersModel member;

    @ManyToOne
    private GroupsModel group;

    @ManyToMany
    private List<RolesModel> roles;

    @Column(
            name = "created_time",
            updatable = false
    )
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(
            name = "updated_time",
            updatable = true
    )
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
