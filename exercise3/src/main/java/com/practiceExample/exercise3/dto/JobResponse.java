package com.practiceExample.exercise3.dto;

import com.practiceExample.exercise3.entity.foreingEntities.Job;
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
