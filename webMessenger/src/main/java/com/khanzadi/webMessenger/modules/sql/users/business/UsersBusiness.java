package com.khanzadi.webMessenger.modules.sql.users.business;

import com.khanzadi.dto.ResultsServiceDto;
import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.dto.contacts.UserContactsDto;
import com.khanzadi.enums.IdentityType;
import com.khanzadi.exeption.MessengerException;
import com.khanzadi.utils.StringUtils;
import com.khanzadi.utils.VerifyObjectUtils;
import com.khanzadi.webMessenger.modules.sql.users.DAO.UserDao;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersBusiness {

    private final UserDao dao;

    @Autowired
    public UsersBusiness(UserDao dao) {
        this.dao = dao;
    }

    //registerUser
    public ResultsServiceDto registerUser(String identity, IdentityType identityType, UsersDto usersDto) throws MessengerException {
        boolean identityIsText  = StringUtils.hasText(identity);
        if (!identityIsText){
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }

        VerifyObjectUtils.isNewUsers(usersDto);
        VerifyObjectUtils.requireNonNull(identity , "identity");
        VerifyObjectUtils.requireNonNull(identityType , "identityType");

        UsersDto userDto = findUserDto(identity , identityType);
        if (userDto != null){
            throw new MessengerException("User is Exists in DB - userId is :" + userDto.getId());
        }

        UsersDto dto = this.dao.insertUser(UsersDto.convertToEntity(usersDto));
        return new ResultsServiceDto(dto);
    }
    //deleteUser
    public ResultsServiceDto deleteUser(String identity , IdentityType identityType) throws MessengerException {
        boolean identityIsText  = StringUtils.hasText(identity);
        if (!identityIsText){
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }

        VerifyObjectUtils.requireNonNull(identity , "identity");
        VerifyObjectUtils.requireNonNull(identityType , "identityType");

        UsersDto userDto = findUserDto(identity , identityType);
        this.dao.deleteOneUserById(userDto.getId());
        return new ResultsServiceDto("identity: " + identity + " deleted");
    }
    //editUser
    public ResultsServiceDto editUser(String identity , IdentityType identityType , UsersDto usersDto) throws MessengerException {
        boolean identityIsText  = StringUtils.hasText(identity);
        if (!identityIsText){
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }

        VerifyObjectUtils.isNewUsers(usersDto);
        VerifyObjectUtils.requireNonNull(identity , "identity");
        VerifyObjectUtils.requireNonNull(identityType , "identityType");

        UsersDto userDto = findUserDto(identity , identityType);
        if (userDto == null) {
            throw new MessengerException("User not Exists Or UserId NotFound");
        }

        UsersDto dto = this.dao.editUser(UsersDto.convertToEntity(userDto));
        return new ResultsServiceDto(dto);
    }
    //findUser
    public ResultsServiceDto findUser(String identity , IdentityType identityType) throws MessengerException {
        boolean identityIsText  = StringUtils.hasText(identity);
        if (!identityIsText){
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }
        VerifyObjectUtils.requireNonNull(identity , "identity");
        VerifyObjectUtils.requireNonNull(identityType , "identityType");
        ResultsServiceDto dto = new ResultsServiceDto();
        switch (identityType) {
            case ID -> {
                dto = new ResultsServiceDto(this.dao.findOneUserById(Long.valueOf(identity)));
            }
            case EMAIL -> {
                //todo
            }
            case USER_NAME -> {
                dto = new ResultsServiceDto(this.dao.findOneUserByUsername(identity));
            }
            case PHONE_NUMBER -> {
                dto = new ResultsServiceDto(this.dao.findOneUserByCellPhone(identity));
            }
            default -> {
                throw new MessengerException("IdentityType is Not valid or Empty " + "identityType: " + identityType);
            }
        }
        return dto;
    }

    public UsersDto findUserDto(String identity , IdentityType identityType) throws MessengerException {
        VerifyObjectUtils.requireNonNull(identity , "identity");
        VerifyObjectUtils.requireNonNull(identityType , "identityType");
        boolean identityIsText  = StringUtils.hasText(identity);
        if (!identityIsText){
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }
        UsersDto dto = null;
        switch (identityType) {
            case ID -> {
                dto = this.dao.findOneUserById(Long.valueOf(identity));
            }
            case EMAIL -> {
                //todo
            }
            case USER_NAME -> {
                dto = this.dao.findOneUserByUsername(identity);
            }
            case PHONE_NUMBER -> {
                dto = this.dao.findOneUserByCellPhone(identity);
            }
            default -> {
                throw new MessengerException("IdentityType is Not valid or Empty " + "identityType: " + identityType);
            }
        }
        if (dto == null){
            throw new MessengerException("User not Exists Or UserId NotFound");
        }
        return dto;
    }

    public UsersDto findUserDto(UserContactsDto contacts) throws MessengerException{
        VerifyObjectUtils.isNewContact(contacts);
        UsersDto dto = null;
        if (contacts.getId() != null){
            dto = this.dao.findOneUserById(contacts.getId());
        } else if (contacts.getEmail() != null){
            dto = this.dao.findOneUserById(contacts.getId());
        } else if (contacts.getCellPhone() != null){
            dto = this.dao.findOneUserById(contacts.getId());
        } else if (contacts.getUsername() != null){
            dto = this.dao.findOneUserById(contacts.getId());
        } else if (contacts.getContactName() != null){
            dto = this.dao.findOneUserById(contacts.getId());
        } else {
          throw new MessengerException("Not Exists Match Fields");
        }
        if (dto == null){
            throw new MessengerException("Contacts Not Found");
        }
        return dto;
    }

    public Boolean isExistsUser(Long id) throws MessengerException {
        return this.dao.isExistsUser(id);
    }

    //--------------------------------------------------------------------------------
    //-------------------------------------contact------------------------------------
    //--------------------------------------------------------------------------------

    //addContact
    public ResultsServiceDto addContactToUserContactList(String identity , IdentityType identityType,
                                                         UserContactsDto contacts) throws MessengerException {
        boolean identityIsText  = StringUtils.hasText(identity);
        if (!identityIsText){
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }

        VerifyObjectUtils.isNewContact(contacts);
        VerifyObjectUtils.requireNonNull(identity , "identity");
        VerifyObjectUtils.requireNonNull(identityType , "identityType");

        UsersDto userDto = findUserDto(identity , identityType);
        UsersDto userContactsDto = findUserDto(contacts);
        userDto.getContacts().add(userContactsDto);

        UsersDto dto = this.dao.addContactToUserContactList(UsersDto.convertToEntity(userDto));
        return new ResultsServiceDto(dto);
    }
    //editContact
    public ResultsServiceDto editContactAtUserContactList(){

    }
    //deleteContact
    public ResultsServiceDto deleteContactAtUserContactList(){

    }
    //Find One Contact's user
    public ResultsServiceDto findContactAtUserContactList(){

    }
    //Find All OF Contacts User
    public ResultsServiceDto findAllContactAtContactList(){

    }
}
