package com.khanzadi.webMessenger.modules.sql.appInfo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AppInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String appName;
    private String appVersion;
    private String developerName;
    private String createdDate;

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
