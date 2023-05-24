package com.routemasterz.repository;

import com.routemasterz.model.Checkpoint;
import com.routemasterz.model.Route;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Route, Long> {
}
