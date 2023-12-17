package com.khanzadi.webMessenger.modules.sql.users.DAO;

import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.exeption.MessengerException;
import com.khanzadi.webMessenger.modules.sql.users.entity.UsersModel;
import com.khanzadi.webMessenger.modules.sql.users.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDao {
    private final UsersRepo repo;

    @Autowired
    public UserDao(UsersRepo repo) {
        this.repo = repo;
    }

    //insert user
    public UsersDto insertUser(UsersModel user) throws MessengerException {
        try {
            UsersModel model = this.repo.saveAndFlush(user);
            return UsersModel.convertToDto(model);
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }
    //deleteOneUserById
    @Transactional
    public void deleteOneUserById(Long id) throws MessengerException {
        try {
            this.repo.deleteById(id);
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }
    //deleteOneUserByUsername
    @Transactional
    public void deleteOneUserByUsername(String username) throws MessengerException {
        try {
            this.repo.deleteByUsername(username);
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }
    //deleteOneUserByCellPhone
    @Transactional
    public void deleteOneUserByCellPhone(String cellPhone) throws MessengerException {
        try {
            this.repo.deleteByCellPhone(cellPhone);
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }

    //edit user
    @Transactional
    public UsersDto editUser(UsersModel user) throws MessengerException {
        try {
            UsersModel model = this.repo.saveAndFlush(user);
            return UsersModel.convertToDto(model);
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }
    //findOneUserById
    public UsersDto findOneUserById(Long id) throws MessengerException {
        try {
            Optional<UsersModel> user = this.repo.findById(id);
            if (user.isPresent()){
                UsersModel model = user.get();
                return UsersModel.convertToDto(model);
            } else {
                throw new MessengerException("User not Exists Or UserId NotFound");
            }
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }
    //findOneUserByUsername
    public UsersDto findOneUserByUsername(String username) throws MessengerException {
        try {
            Optional<UsersModel> user = this.repo.findByUsername(username);
            if (user.isPresent()){
                UsersModel model = user.get();
                return UsersModel.convertToDto(model);
            } else {
                throw new MessengerException("User not Exists Or UserId NotFound");
            }
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }
    //findOneUserByCellPhone
    public UsersDto findOneUserByCellPhone(String cellPhone) throws MessengerException {
        try {
            Optional<UsersModel> user = this.repo.findByCellPhone(cellPhone);
            if (user.isPresent()){
                UsersModel model = user.get();
                return UsersModel.convertToDto(model);
            } else {
                throw new MessengerException("User not Exists Or UserId NotFound");
            }
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }

    public Boolean isExistsUser(Long id) throws MessengerException {
        try {
            return this.repo.existsById(id);
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }
}
