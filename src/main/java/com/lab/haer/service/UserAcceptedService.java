package com.lab.haer.service;

import com.lab.haer.dto.UserApplyDto;

import java.util.List;

public interface UserAcceptedService {

    public List<UserApplyDto> findAllJobUserById(String userId);

}
