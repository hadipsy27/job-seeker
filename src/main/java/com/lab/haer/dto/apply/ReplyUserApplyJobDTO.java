package com.lab.haer.dto.apply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyUserApplyJobDTO {

    private String userId;
    private String status;
    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private String interviewLink;
}
