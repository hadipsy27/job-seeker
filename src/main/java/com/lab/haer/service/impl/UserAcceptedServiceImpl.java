package com.lab.haer.service.impl;

import com.lab.haer.dto.UserApplyDto;
import com.lab.haer.repository.UserApplyRepository;
import com.lab.haer.service.UserAcceptedService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserAcceptedServiceImpl implements UserAcceptedService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAcceptedServiceImpl.class);

    private UserApplyRepository userApplyRepository;

    @Override
    public List<UserApplyDto> findAllJobUserById(String userId) {

        List<Object[]> resultList = userApplyRepository.findUserApplyByUserId(userId);
        List<UserApplyDto> userApplyDtoList = new ArrayList<>();

        for (Object[] result : resultList) {
            UserApplyDto userApplyDto = new UserApplyDto();

            userApplyDto.setApplyId((String) result[0]);
            userApplyDto.setStatus((String) result[1]);

            // Check for null before converting java.sql.Date to java.time.LocalDate
            java.sql.Date sqlDate = (java.sql.Date) result[2];
            userApplyDto.setInterviewDate(sqlDate != null ? sqlDate.toLocalDate() : null);

            // Check for null before converting java.sql.Time to java.time.LocalTime
            java.sql.Time sqlTime = (java.sql.Time) result[3];
            userApplyDto.setInterviewTime(sqlTime != null ? sqlTime.toLocalTime() : null);

            userApplyDto.setJobId((String) result[4]);
            userApplyDto.setTitle((String) result[5]);
            userApplyDto.setSortDescription((String) result[6]);
            userApplyDto.setUploadDate((String) result[7]);
            userApplyDto.setLocation((String) result[8]);

            LOGGER.info("{}", userApplyDto);
            userApplyDtoList.add(userApplyDto);
        }

        return userApplyDtoList;
    }
}
