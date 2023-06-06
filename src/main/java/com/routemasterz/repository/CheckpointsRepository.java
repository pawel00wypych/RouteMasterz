package com.routemasterz.repository;

import com.routemasterz.model.Checkpoint;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckpointsRepository extends JpaRepository<Checkpoint, Long> {

    @Transactional
    @Query(value = "SELECT * FROM checkpoint " +
            "WHERE checkpoint.route_id = :id", nativeQuery = true)
    List<Checkpoint> findCheckpointsByRouteId(@Param("id") Long id);
}
