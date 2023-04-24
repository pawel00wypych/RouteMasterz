package com.routemasterz.repository;

import com.routemasterz.model.BlackListJWToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JWTokenRepository extends JpaRepository<BlackListJWToken, Long> {
    boolean existsByToken(String jwt);
}
