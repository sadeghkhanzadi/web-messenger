package com.khanzadi.webMessenger.modules.noSql.messages.documents;

import com.khanzadi.webMessenger.modules.noSql.users.documents.UsersDocumentModel;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MessageDocumentModel implements Serializable {
    @Id
    private String id;

    private String userId;
    private String text;

    private List<UsersDocumentModel> usersIdReplier;
    private List<MessageDocumentModel> messageReply;

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
