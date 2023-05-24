package com.routemasterz.dto;

public record CheckpointDTO(String country,
                            String street,
                            String city,
                            String state,
                            String postalcode,
                            String hour,
                            int order) {
}
