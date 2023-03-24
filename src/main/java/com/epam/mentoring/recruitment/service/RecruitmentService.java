package com.epam.mentoring.recruitment.service;

import java.util.UUID;

import com.epam.mentoring.recruitment.dto.CandidateDto;
import com.epam.mentoring.recruitment.mapper.RecruitmentMapper;
import com.epam.mentoring.recruitment.repository.CandidateRepository;
import com.epam.mentoring.recruitment.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final CandidateRepository candidateRepository;

    private final CompanyRepository companyRepository;

    private final RecruitmentMapper recruitmentMapper;

    public CandidateDto addCandidate(CandidateDto candidateDto) {
        var candidate = recruitmentMapper.toCandidate(candidateDto);
        var optionalCompany = companyRepository.findCompanyByName(candidate.getCompany().getName());
        optionalCompany.ifPresent(candidate::setCompany);
        if (candidateRepository.existsByGivenNameAndFamilyName(candidate.getGivenName(), candidate.getFamilyName())) {
            throw new RuntimeException();
        }
        return recruitmentMapper.toCandidateDto(candidateRepository.save(candidate));
    }

    public CandidateDto findCandidateById(UUID id) {
        return candidateRepository.findById(id).map(recruitmentMapper::toCandidateDto)
                .orElseThrow(() -> new RuntimeException());
    }

    public void deleteCandidateById(UUID id) {
        var candidate = candidateRepository.findById(id).orElseThrow(() -> new RuntimeException());
        candidateRepository.delete(candidate);
    }

}
