package com.lab.haer.dto.apply;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyUserApplyJobDTO {

    private String userId;
    private String status;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date interviewDate;
    @JsonFormat(pattern = "HH.mm")
    private LocalTime interviewTime;
    private String interviewLink;
}
