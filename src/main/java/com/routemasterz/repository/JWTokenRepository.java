package com.routemasterz.repository;

import com.routemasterz.model.BlackListJWToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTokenRepository extends JpaRepository<BlackListJWToken, Long> {
    boolean existsByToken(String jwt);
}
