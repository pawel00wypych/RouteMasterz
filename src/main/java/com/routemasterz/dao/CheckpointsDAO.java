package com.routemasterz.dao;

import com.routemasterz.model.Checkpoint;

import java.util.List;

public interface CheckpointsDAO {
    void saveCheckpoint(Checkpoint checkpoint);

    List<Checkpoint> findCheckpointsByRouteId(Long id);
}
