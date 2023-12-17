package com.khanzadi.webMessenger.modules.sql.users.service;

import com.khanzadi.dto.ResultsServiceDto;
import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.enums.IdentityType;
import com.khanzadi.webMessenger.modules.sql.users.business.UsersBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersBusiness business;

    @Autowired
    public UsersService(UsersBusiness business) {
        this.business = business;
    }

    //registerUser
    public ResultsServiceDto registerUser(String identity , IdentityType identityType , UsersDto usersDto){
        return this.business.registerUser(identity , identityType , usersDto);
    }
    //deleteUser
    public ResultsServiceDto deleteUser(String identity , IdentityType identityType , UsersDto usersDto){
        return business.deleteUser(identity , identityType , usersDto);
    }
    //editUser
    public ResultsServiceDto editUser(String identity , IdentityType identityType , UsersDto usersDto){
        return business.editUser(identity , identityType , usersDto);
    }
    //findUser
    public ResultsServiceDto findUser(String identity , IdentityType identityType){
        return business.findUser((identity , identityType);
    }

    //addContact
    //editeContact
    //deleteContact
    //Find One Contact's user
    //Find All OF Contacts User
}
