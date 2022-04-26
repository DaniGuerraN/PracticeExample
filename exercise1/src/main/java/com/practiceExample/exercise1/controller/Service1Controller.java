package com.practiceExample.exercise1.controller;


import com.practiceExample.exercise1.dto.*;
import com.practiceExample.exercise1.service.impl.EmployeeServiceImpl;
import com.practiceExample.exercise1.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Service1Controller {

    private final EmployeeServiceImpl service;
    private final JobServiceImpl jobService;

    @Autowired
    public Service1Controller(EmployeeServiceImpl service, JobServiceImpl jobService) {
        this.service = service;
        this.jobService = jobService;
    }


    @PostMapping("/api/service1/addEmployee")
    public ResponseEntity<ResponseType1> store(@RequestBody EmployeeCreateOrUpdateDTO employeeCreateOrUpdateDTO) {

        return ResponseEntity.ok().body(service.saveEmployee(employeeCreateOrUpdateDTO));

    }

    @GetMapping("/api/service1/employee/{employeeId}")
    public ResponseEntity<EmployeeResponse> search(@PathVariable("employeeId") Long employeeId) {

        return ResponseEntity.ok().body(service.findByEmployeeID(employeeId));

    }

    @PostMapping("/api/service1/employeesByJob")
    public ResponseEntity<EmployeesResponse> getByJob(@RequestBody GetByJobDTO getByJobDTO) {

        return ResponseEntity.ok().body(service.getEmployeesByJob(getByJobDTO));

    }

    @GetMapping("/api/service1/findJob/{jobId}")
    public ResponseEntity<JobResponse> searchJob(@PathVariable("employeeId") Long jobId) {

        return ResponseEntity.ok().body(jobService.findJobById(jobId));

    }

}
