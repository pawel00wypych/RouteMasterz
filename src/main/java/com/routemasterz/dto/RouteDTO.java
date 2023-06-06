package com.routemasterz.dto;

import com.routemasterz.model.Checkpoint;

import java.util.List;

public record RouteDTO(Long id,
                       String name,
                       List<Checkpoint> checkpoints) {
}
