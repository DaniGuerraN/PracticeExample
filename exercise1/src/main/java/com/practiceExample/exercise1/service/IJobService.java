package com.practiceExample.exercise1.service;

import com.practiceExample.exercise1.dto.GetByJobDTO;
import com.practiceExample.exercise1.dto.JobResponse;

public interface IJobService {

    JobResponse findJobById(Long id);
}
