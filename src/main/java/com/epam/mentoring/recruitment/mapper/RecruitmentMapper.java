package com.epam.mentoring.recruitment.mapper;

import com.epam.mentoring.recruitment.dto.CandidateDto;
import com.epam.mentoring.recruitment.dto.CompanyDto;
import com.epam.mentoring.recruitment.model.Candidate;
import com.epam.mentoring.recruitment.model.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecruitmentMapper {

    CandidateDto toCandidateDto(Candidate candidate);

    Candidate toCandidate(CandidateDto candidateDto);

    CompanyDto toCompanyDto(Company company);

    Company toCompany(CompanyDto companyDto);

}
