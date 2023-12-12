package com.lab.haer.service;

import com.lab.haer.dto.apply.*;

import java.util.List;

public interface ApplyService {

    public List<ApplyHRResponseDto> findAllApplyJob();

    public ApplyUserCreateDto createUserApplyJob(ApplyUserCreateDto applyUserCreateDto);

    public ApplyHRDetailResponseDto findJobUserApplied(String applyId);

    public ApplyJobUserResponseDto HRAppliedJobUser(String applyId, ReplyUserApplyJobDTO replyUserApplyJobDTO);

}
