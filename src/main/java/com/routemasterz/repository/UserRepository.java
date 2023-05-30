package com.routemasterz.repository;

import com.routemasterz.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserByEmail(String email);

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE my_user " +
            "SET password = :password " +
            "WHERE id = :id" , nativeQuery = true)
    void setNewPassword(@Param("id") long id,@Param("password") String password);
}
