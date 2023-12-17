package com.khanzadi.webMessenger.modules.sql.users.business;

import com.khanzadi.dto.ResultsServiceDto;
import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.enums.IdentityType;
import com.khanzadi.exeption.MessengerException;
import com.khanzadi.utils.StringUtils;
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
        //Todo Checked Object
        StringUtils.requireNonNull(identity , "identity");
        StringUtils.requireNonNull(identityType , "identityType");
        boolean identityIsText  = StringUtils.hasText(identity);
        if (!identityIsText){
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }

        ResultsServiceDto serviceDto = findUser(identity , identityType);
        if (serviceDto != null){
            if (serviceDto.getResult() instanceof UsersDto ud){
                throw new MessengerException("User is Exists in DB - userId is :" + ud.getId());
            }
        }
        UsersDto dto = this.dao.insertUser(UsersDto.convertToEntity(usersDto));
        return new ResultsServiceDto(dto);
    }
    //deleteUser
    public ResultsServiceDto deleteUser(String identity , IdentityType identityType , UsersDto usersDto) throws MessengerException {
        if (!identity.isEmpty() && !identity.isBlank()) {
            ResultsServiceDto dto = new ResultsServiceDto();
            switch (identityType) {
                case ID -> {
                    this.dao.deleteOneUserById(Long.valueOf(identity));
                    dto = new ResultsServiceDto("identity: " + identity + " deleted");
                }
                case EMAIL -> {
                    //todo
                }
                case USER_NAME -> {
                    this.dao.deleteOneUserByUsername(identity);
                    dto = new ResultsServiceDto("identity: " + identity + " deleted");
                }
                case PHONE_NUMBER -> {
                    this.dao.deleteOneUserByCellPhone(identity);
                    dto = new ResultsServiceDto("identity: " + identity + " deleted");
                }
                default -> {
                    throw new MessengerException("IdentityType is Not valid or Empty " + "identityType: " + identityType);
                }
            }
            return dto;
        } else {
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }
    }
    //editUser
    public ResultsServiceDto editUser(String identity , IdentityType identityType , UsersDto usersDto) throws MessengerException {
        UsersDto dto = this.dao.editUser(UsersDto.convertToEntity(usersDto));
        return new ResultsServiceDto(dto);
    }
    //findUser
    public ResultsServiceDto findUser(String identity , IdentityType identityType) throws MessengerException {
        StringUtils.requireNonNull(identity , "identity");
        StringUtils.requireNonNull(identityType , "identityType");
        boolean identityIsText  = StringUtils.hasText(identity);
        if (!identityIsText){
            throw new MessengerException("Identity is null Or Empty " + "identity: " + identity);
        }
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

    public Boolean isExistsUser(Long id) throws MessengerException {
        return this.dao.isExistsUser(id);
    }

    //addContact
    //editeContact
    //deleteContact
    //Find One Contact's user
    //Find All OF Contacts User
}
