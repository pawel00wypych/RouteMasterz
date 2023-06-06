package com.routemasterz.dao;

import com.routemasterz.model.Checkpoint;
import com.routemasterz.repository.CheckpointsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("checkpointsJPA")
public class CheckpointsDataAccessService implements CheckpointsDAO{
    CheckpointsRepository repository;

    public CheckpointsDataAccessService(CheckpointsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveCheckpoint(Checkpoint checkpoint) {
        repository.save(checkpoint);
    }

    @Override
    public List<Checkpoint> findCheckpointsByRouteId(Long id) {
        return repository.findCheckpointsByRouteId(id);
    }
}
