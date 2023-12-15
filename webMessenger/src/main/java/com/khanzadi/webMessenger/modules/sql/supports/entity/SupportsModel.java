package com.khanzadi.webMessenger.modules.sql.supports.entity;

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
public class SupportsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cellPhone;
    private String email;
    private String text;
    private String address;

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
