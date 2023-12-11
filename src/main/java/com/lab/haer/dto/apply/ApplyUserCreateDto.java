package com.lab.haer.dto.apply;

import com.lab.haer.entity.Job;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyUserCreateDto {


    private boolean applied;
    private String jobId;
    private String userId;

    public boolean getApplied() {
        return applied;
    }
}
