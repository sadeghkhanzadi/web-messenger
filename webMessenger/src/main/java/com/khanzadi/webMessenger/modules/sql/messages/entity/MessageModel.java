package com.khanzadi.webMessenger.modules.sql.messages.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.khanzadi.webMessenger.modules.sql.users.entity.UsersModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MessageModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    //todo image
    //todo media video audio
    @OneToOne
    private UsersModel user;
    @ManyToMany
    private List<UsersModel> usersReplier;
    @ManyToMany
    private List<MessageModel> messagesReply;

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
