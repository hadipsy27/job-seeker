package com.lab.haer.service;

import com.lab.haer.dto.apply.ApplyHRResponseDto;
import com.lab.haer.dto.apply.ApplyUserCreateDto;

import java.util.List;

public interface ApplyService {

    public List<ApplyUserCreateDto> findAllApplyJob();

    public List<ApplyHRResponseDto> findJobApplied();
    public ApplyUserCreateDto createUserApplyJob(ApplyUserCreateDto applyUserCreateDto);

}
