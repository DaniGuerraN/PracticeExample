package com.practiceExample.exercise1.dto;

import com.practiceExample.exercise1.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse extends ApiResponse{

    private Job job;

    public JobResponse(Boolean success, Job job) {
        super(success);
        this.job = job;
    }
}
