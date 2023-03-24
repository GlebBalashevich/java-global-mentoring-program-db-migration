package com.epam.mentoring.recruitment.repository;

import java.util.UUID;

import com.epam.mentoring.recruitment.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {

    Boolean existsByGivenNameAndFamilyName(String givenName, String familyName);
}
