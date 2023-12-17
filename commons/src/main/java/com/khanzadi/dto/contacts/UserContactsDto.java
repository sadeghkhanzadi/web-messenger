package com.khanzadi.dto.contacts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserContactsDto {
    private Long id;
    private String contactName;
    private String username;
    private String cellPhone;
    private String email;
}
