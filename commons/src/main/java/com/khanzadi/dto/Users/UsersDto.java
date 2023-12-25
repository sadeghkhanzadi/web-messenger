package com.khanzadi.dto.Users;

import com.khanzadi.dto.contacts.UserContactsDto;
import com.khanzadi.webMessenger.modules.sql.users.entity.UsersModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UsersDto {
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

    private List<UsersDto> contacts;

    public static class Builder{
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

        private List<UsersDto> contacts;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder uuid(String uuid){
            this.uuid = uuid;
            return this;
        }
        public Builder firstName(String fName){
            this.firstName = fName;
            return this;
        }
        public Builder lastName(String lName){
            this.lastName = lName;
            return this;
        }
        public Builder profileImage(String path){
            this.profileImage = path;
            return this;
        }
        public Builder cellPhone(String phone){
            this.cellPhone = phone;
            return this;
        }
        public Builder username(String username){
            this.username = username;
            return this;
        }
        public Builder email(String mail){
            this.email = mail;
            return this;
        }
        public Builder profileName(String pName){
            this.profileName = pName;
            return this;
        }
        public Builder password(String pass){
            this.password = pass;
            return this;
        }
        public Builder isVerified_email(Boolean b){
            this.isVerified_email = b;
            return this;
        }
        public Builder isVerified_cellPhone(Boolean b){
            this.isVerified_cellPhone = b;
            return this;
        }
        public Builder userStatus(String status){
            this.userStatus = status;
            return this;
        }
        public Builder enabled(Boolean b){
            this.enabled = b;
            return this;
        }
        public Builder contacts(List<UsersDto> ct){
            this.contacts = ct;
            return this;
        }
        public UsersDto build(){
            return new UsersDto(this);
        }
    }

    public UsersDto(Builder builder) {
        this.id = builder.id;
        this.uuid = builder.uuid;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.profileImage = builder.profileImage;
        this.cellPhone = builder.cellPhone;
        this.username = builder.username;
        this.email = builder.email;
        this.profileName = builder.profileName;
        this.password = builder.password;
        this.isVerified_email = builder.isVerified_email;
        this.isVerified_cellPhone = builder.isVerified_cellPhone;
        this.userStatus = builder.userStatus;
        this.enabled = builder.enabled;
        this.contacts = builder.contacts;
    }

    public static UsersModel convertToEntity(UsersDto dto){
        List<UsersModel> users = new ArrayList<>();
        if ( dto.contacts != null || !dto.contacts.isEmpty()){
            dto.contacts.forEach(C -> {
                users.add(convertToEntity(C));
            });
        }
        return new UsersModel.Builder()
                .id(dto.id).uuid(dto.uuid)
                .firstName(dto.firstName).lastName(dto.lastName)
                .username(dto.username).password(dto.password)
                .email(dto.email).cellPhone(dto.cellPhone)
                .profileImage(dto.profileImage).profileName(dto.profileName)
                .isVerified_email(dto.isVerified_email).isVerified_cellPhone(dto.isVerified_cellPhone)
                .userStatus(dto.userStatus).enabled(dto.enabled)
                .contact(users)
                .build();
    }
}
