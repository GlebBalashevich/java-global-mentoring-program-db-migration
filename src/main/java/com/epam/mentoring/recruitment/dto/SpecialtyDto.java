package com.epam.mentoring.recruitment.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class SpecialtyDto {

    private UUID id;

    private String name;

    private Instant createDate;

    private Instant lastUpdateDate;

}
