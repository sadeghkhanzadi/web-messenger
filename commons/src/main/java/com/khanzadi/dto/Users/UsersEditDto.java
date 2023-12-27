package com.khanzadi.dto.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersEditDto {
    private Long id;

    private String uuid;

    private String email;
    private String firstName;
    private String lastName;
    private String profileName;
    private String profileImage;

    public static UsersDto convertToUsersDto(UsersEditDto dto){
        return new UsersDto.Builder()
                .id(dto.getId()).uuid(dto.getUuid())
                .firstName(dto.getFirstName()).lastName(dto.getLastName()).email(dto.getEmail())
                .profileName(dto.getProfileName()).profileImage(dto.getProfileImage())
                .build();
    }
}
