package com.khanzadi.dto.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersEditPasswordDto {
    private Long id;

    private String uuid;

    private String email;
    private String username;
    private String password;
    private String cellPhone;

    public static UsersDto convertToUsersDto(UsersEditPasswordDto dto){
        return new UsersDto.Builder()
                .id(dto.getId()).uuid(dto.getUuid())
                .username(dto.getUsername()).email(dto.getEmail())
                .password(dto.getPassword()).cellPhone(dto.getCellPhone())
                .build();
    }
}
