package com.routemasterz.repository;

import com.routemasterz.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckpointsRepository extends JpaRepository<Checkpoint, Long> {
}
