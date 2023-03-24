package com.epam.mentoring.recruitment.dto;

import java.time.Instant;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyDto {

    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String website;

    @NotBlank
    private String email;

    private String address;

    private Instant createDate;

    private Instant lastUpdateDate;

}
