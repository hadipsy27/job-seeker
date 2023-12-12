package com.lab.haer.service;

import com.lab.haer.dto.apply.ApplyHRDetailResponseDto;
import com.lab.haer.dto.apply.ApplyHRResponseDto;
import com.lab.haer.dto.apply.ApplyUserCreateDto;

import java.util.List;

public interface ApplyService {

    public List<ApplyHRResponseDto> findAllApplyJob();

    public ApplyUserCreateDto createUserApplyJob(ApplyUserCreateDto applyUserCreateDto);

    public ApplyHRDetailResponseDto findJobUserApplied(String applyId);

}
