package com.routemasterz.repository;

import com.routemasterz.model.UserEntityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserEntityDetailsRepository extends JpaRepository<UserEntityDetails, Long> {
    @Transactional
    @Query(value = "SELECT u.id, u.name, u.surname, u.residence, u.company, u.phone_number, u.profile_photo, u.created_at" +
            " FROM user_details u " +
            "JOIN my_user on u.id = my_user.user_entity_details_id WHERE my_user.email = :email", nativeQuery = true)
    UserEntityDetails findUserEntityDetailsByEmail(@Param("email") String email);
}
