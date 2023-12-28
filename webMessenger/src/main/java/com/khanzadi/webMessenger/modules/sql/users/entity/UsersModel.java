package com.khanzadi.webMessenger.modules.sql.users.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.khanzadi.dto.Users.UsersDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UsersModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    private List<UsersModel> contacts;

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

        private List<UsersModel> contacts;

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

        public Builder contact(List<UsersModel> ct){
            this.contacts = ct;
            return this;
        }
        public UsersModel build(){
            return new UsersModel(this);
        }
    }

    public UsersModel(Builder builder){
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

    public static UsersDto convertToDto(UsersModel model){
        List<UsersDto> users = new ArrayList<>();
        if ( model.contacts != null){
            model.contacts.forEach(C -> {
                users.add(convertToDto(C));
            });
        }
        return new UsersDto.Builder()
                .id(model.id).uuid(model.uuid)
                .firstName(model.firstName).lastName(model.lastName)
                .username(model.username).password(model.password)
                .email(model.email).cellPhone(model.cellPhone)
                .profileImage(model.profileImage).profileName(model.profileName)
                .isVerified_email(model.isVerified_email).isVerified_cellPhone(model.isVerified_cellPhone)
                .userStatus(model.userStatus).enabled(model.enabled)
                .contacts(users)
                .build();
    }
}
