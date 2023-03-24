package com.epam.mentoring.recruitment.repository;

import java.util.Optional;
import java.util.UUID;

import com.epam.mentoring.recruitment.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findCompanyByName(String name);

}
