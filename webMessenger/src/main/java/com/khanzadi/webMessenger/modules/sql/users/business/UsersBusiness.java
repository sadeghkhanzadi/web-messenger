package com.khanzadi.webMessenger.modules.sql.users.business;

import com.khanzadi.dto.ResultsServiceDto;
import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.enums.IdentityType;
import com.khanzadi.exeption.MessengerException;
import com.khanzadi.utils.StringUtils;
import com.khanzadi.utils.VerifyObjectUtils;
import com.khanzadi.webMessenger.modules.sql.users.DAO.UserDao;
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

        switch (identityType) {
            case ID -> {
                return this.dao.findOneUserById(Long.valueOf(identity));
            }
            case EMAIL -> {
                //todo
            }
            case USER_NAME -> {
                return this.dao.findOneUserByUsername(identity);
            }
            case PHONE_NUMBER -> {
                return this.dao.findOneUserByCellPhone(identity);
            }
            default -> {
                throw new MessengerException("IdentityType is Not valid or Empty " + "identityType: " + identityType);
            }
        }
        return null;
    }

    public Boolean isExistsUser(Long id) throws MessengerException {
        return this.dao.isExistsUser(id);
    }

    //addContact
    //editeContact
    //deleteContact
    //Find One Contact's user
    //Find All OF Contacts User
}
