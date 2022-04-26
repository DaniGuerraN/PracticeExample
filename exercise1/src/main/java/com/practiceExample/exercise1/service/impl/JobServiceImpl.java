package com.practiceExample.exercise1.service.impl;

import com.practiceExample.exercise1.dto.EmployeeResponse;
import com.practiceExample.exercise1.dto.JobResponse;
import com.practiceExample.exercise1.entity.Employee;
import com.practiceExample.exercise1.entity.Job;
import com.practiceExample.exercise1.exceptions.ResourceNotFoundException;
import com.practiceExample.exercise1.repository.IJobRepository;
import com.practiceExample.exercise1.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.practiceExample.exercise1.utils.AppConstants.*;

@Service
public class JobServiceImpl implements IJobService {
    private final IJobRepository jobRepository;

    @Autowired
    public JobServiceImpl(IJobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobResponse findJobById(Long id) {

        Job job = jobRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(JOB, ID, id));

        return new JobResponse(true, job);
    }
}
