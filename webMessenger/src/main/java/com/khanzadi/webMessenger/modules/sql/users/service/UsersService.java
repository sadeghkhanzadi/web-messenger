package com.khanzadi.webMessenger.modules.sql.users.service;

import com.khanzadi.dto.ResultsServiceDto;
import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.dto.contacts.UserContactsDto;
import com.khanzadi.enums.IdentityType;
import com.khanzadi.exeption.MessengerException;
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
    public ResultsServiceDto registerUser(String identity , IdentityType identityType , UsersDto usersDto) throws MessengerException {
        return this.business.registerUser(identity , identityType , usersDto);
    }
    //deleteUser
    public ResultsServiceDto deleteUser(String identity , IdentityType identityType) throws MessengerException {
        return this.business.deleteUser(identity , identityType);
    }
    //editUser
    public ResultsServiceDto editUser(String identity , IdentityType identityType , UsersDto usersDto) throws MessengerException {
        return this.business.editUser(identity , identityType , usersDto);
    }
    //findUser
    public ResultsServiceDto findUser(String identity , IdentityType identityType) throws MessengerException {
        return this.business.findUser(identity,identityType);
    }

    //addContact
    public ResultsServiceDto addContactToUserContactList(String identity , IdentityType identityType,
                                                         UserContactsDto contacts) throws MessengerException {
        return this.business.addContactToUserContactList(identity , identityType, contacts);
    }
    //editContact
    public ResultsServiceDto editContactAtUserContactList(){
        return this.business.editContactAtUserContactList();
    }
    //deleteContact
    public ResultsServiceDto deleteContactAtUserContactList(){
        return this.business.deleteContactAtUserContactList();
    }
    //Find One Contact's user
    public ResultsServiceDto findContactAtUserContactList(){
        return this.business.findContactAtUserContactList();
    }
    //Find All OF Contacts User
    public ResultsServiceDto findAllContactAtContactList(){
        return this.business.findAllContactAtContactList();
    }
}
