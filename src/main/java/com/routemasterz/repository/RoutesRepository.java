package com.routemasterz.repository;

import com.routemasterz.model.Route;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutesRepository extends JpaRepository<Route, Long> {

    @Transactional
    @Query(value = "SELECT * FROM route WHERE route.logistician_id = :logisticianId", nativeQuery = true)
    List<Route> findAllRoutesById(@Param("logisticianId") Long logisticianId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM route WHERE route.id = :routeId", nativeQuery = true)
    void removeRouteById(@Param("routeId") Long routeId);
}
