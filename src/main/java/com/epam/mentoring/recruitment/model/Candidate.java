package com.epam.mentoring.recruitment.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "candidates")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String givenName;

    private String familyName;

    private SpecialtyEnum specialty;

    @OneToMany(cascade = { CascadeType.ALL})
    @JoinColumn(name = "id")
    private List<Specialty> specialties;

    @ManyToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    private String email;

    private String phoneNumber;

    @CreatedDate
    private Instant createDate;

    @LastModifiedDate
    private Instant lastUpdateDate;

}
