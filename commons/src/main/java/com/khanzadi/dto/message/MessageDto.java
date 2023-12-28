package com.khanzadi.dto.message;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
    private Long messageId;
    private Long userId;
    private String uuid;
    private String profileName;
    private String text;
    //todo image
    //todo media video audio
    private MessageDto messageDtoReply;
}
