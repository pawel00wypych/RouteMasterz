package com.routemasterz.repository;

import com.routemasterz.dto.ExtendedUserDetailsDTO;
import com.routemasterz.model.Role;
import com.routemasterz.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Transactional
    @Query(value = "SELECT * " +
            "FROM my_user " +
            "WHERE role != 'ADMIN'", nativeQuery = true)
    List<UserEntity> getAllNonAdminUsers();

    @Transactional
    @Modifying
    @Query(value = "UPDATE my_user " +
            "SET role =:newRole " +
            "WHERE id =:userId", nativeQuery = true)
    void changeUserRole(@Param("userId") Long userId,@Param("newRole") String newRole);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user_details " +
            "SET company =:company " +
            "WHERE id = (SELECT id FROM my_user WHERE id = :userId)", nativeQuery = true)
    void changeUserCompany(@Param("userId") Long userId,@Param("company") String company);
}
