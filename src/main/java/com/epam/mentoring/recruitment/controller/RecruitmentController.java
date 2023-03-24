package com.epam.mentoring.recruitment.controller;

import java.util.UUID;

import com.epam.mentoring.recruitment.dto.CandidateDto;
import com.epam.mentoring.recruitment.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recruitments")
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CandidateDto addCandidate(@RequestBody CandidateDto candidateDto){
        return recruitmentService.addCandidate(candidateDto);
    }

    @GetMapping("/{id}")
    public CandidateDto findCandidateById(@PathVariable UUID id){
        return recruitmentService.findCandidateById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCandidateById(@PathVariable UUID id){
        recruitmentService.deleteCandidateById(id);
    }


}
