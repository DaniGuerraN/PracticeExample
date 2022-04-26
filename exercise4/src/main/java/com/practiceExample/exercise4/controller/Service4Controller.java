package com.practiceExample.exercise4.controller;

import com.practiceExample.exercise4.dto.WorkedHoursDTO;
import com.practiceExample.exercise4.dto.WorkedHoursResponse;
import com.practiceExample.exercise4.service.impl.WorkedHoursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service4Controller {

    private final WorkedHoursServiceImpl service;

    @Autowired
    public Service4Controller(WorkedHoursServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/api/service4/totalHours")
    public ResponseEntity<WorkedHoursResponse> totalHours(@RequestBody WorkedHoursDTO workedHoursDTO){
        return ResponseEntity.ok().body(service.totalWorkedHours(workedHoursDTO));
    }
}
