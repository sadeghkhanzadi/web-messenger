package com.khanzadi.webMessenger.modules.noSql.users.documents;

import com.khanzadi.dto.Users.UsersDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UsersDocumentModel implements Serializable {
    @Id
    private Long id;

    private String uuid;

    private String firstName;
    private String lastName;
    private String profileImage; //Path Profile
    private String cellPhone;
    private String username;
    private String email;
    private String profileName;
    private String password;
    private Boolean isVerified_email;
    private Boolean isVerified_cellPhone;
    private String userStatus; //Enum UserStatus
    private Boolean enabled; //user Active on NotActive
    private List<UsersDocumentModel> contacts;

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
