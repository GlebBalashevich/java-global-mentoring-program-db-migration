package com.epam.mentoring.recruitment.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.epam.mentoring.recruitment.model.Specialty;
import com.epam.mentoring.recruitment.model.SpecialtyEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CandidateDto {

    private UUID id;

    @NotBlank
    private String givenName;

    @NotEmpty
    private String familyName;

    @NotNull
    private SpecialtyEnum specialty;

    private List<SpecialtyDto> specialties;

    @Valid
    @NotNull
    private CompanyDto company;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    private Instant createDate;

    private Instant lastUpdateDate;

}
