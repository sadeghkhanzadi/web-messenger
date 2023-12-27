package com.khanzadi.dto.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersAddDto {
    private String email;
    private String username;
    private String password;
    private String cellPhone;
    private String firstName;
    private String lastName;
    private String profileName;
    private String profileImage; //Path Profile

    public static UsersDto convertToUsersDto(UsersAddDto dto){
        return new UsersDto.Builder()
                .username(dto.getUsername()).email(dto.getEmail())
                .password(dto.getPassword()).cellPhone(dto.getCellPhone())
                .firstName(dto.getFirstName()).lastName(dto.getLastName())
                .profileName(dto.getProfileName()).profileImage(dto.getProfileImage())
                .build();
    }
}
