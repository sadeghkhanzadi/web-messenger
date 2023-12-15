package com.khanzadi.webMessenger.modules.sql.contacts.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String uuid;

    private String firstName;
    private String lastName;
    private String profileImage; //Path Profile
    private String cellPhone;
    private String email;
    private String profileName;
    private String password;
    private Boolean isVerified_email;
    private Boolean isVerified_cellPhone;
    private String userStatus; //Enum UserStatus
    private Boolean enabled; //user Active on NotActive

    @ManyToMany
    private List<UsersModel> contacts;

    @Column(
            name = "created_time",
            updatable = false
    )
    private LocalDateTime createdAt;
    @Column(
            name = "updated_time",
            updatable = true
    )
    private LocalDateTime updatedAt;
}
