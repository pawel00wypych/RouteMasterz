package com.routemasterz.dto;

public record SaveRouteRequest(CheckpointDTO[] checkpoints,
                               String routeName) {
}
