package com.practiceExample.exercise3.controller;

import com.practiceExample.exercise3.dto.EmployeesResponse;
import com.practiceExample.exercise3.dto.GetByJobDTO;
import com.practiceExample.exercise3.service.impl.EmployeeJobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service3Controller {

    private final EmployeeJobServiceImpl service;

    @Autowired
    public Service3Controller(EmployeeJobServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/api/service3/employeesByJob")
    public ResponseEntity<String> getByJob(@RequestBody GetByJobDTO getByJobDTO) {

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(service.allEmployeesByJob(getByJobDTO));

    }
}
