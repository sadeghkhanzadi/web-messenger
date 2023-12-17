package com.khanzadi.webMessenger.modules.sql.users.repository;

import com.khanzadi.webMessenger.modules.sql.users.entity.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<UsersModel , Long> {

    void deleteByUsername(String username);

    void deleteByCellPhone(String cellPhone);

    Optional<UsersModel> findById(Long id);

    Optional<UsersModel> findByUsername(String username);

    Optional<UsersModel> findByCellPhone(String cellPhone);
}
