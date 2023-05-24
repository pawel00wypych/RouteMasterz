package com.routemasterz.dtoMappers;

import com.routemasterz.dto.CheckpointDTO;
import com.routemasterz.model.Checkpoint;

import java.util.function.Function;

public class CheckpointDTOMapper implements Function<Checkpoint, CheckpointDTO> {
    @Override
    public CheckpointDTO apply(Checkpoint checkpoint) {
        return new CheckpointDTO(checkpoint.getCountry(),
                checkpoint.getStreet(),
                checkpoint.getCity(),
                checkpoint.getState(),
                checkpoint.getPostalcode(),
                checkpoint.getHour(),
                checkpoint.getCheckpointOrder());
    }
}
