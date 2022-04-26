package com.practiceExample.exercise2.controller;

import com.practiceExample.exercise2.dto.*;
import com.practiceExample.exercise2.service.impl.EmployeeWorkedHoursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2Controller {

    private final EmployeeWorkedHoursServiceImpl service;

    @Autowired
    public Service2Controller(EmployeeWorkedHoursServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/api/service2/addHours")
    public ResponseEntity<ResponseType1> store(@RequestBody AddWorkedHours addWorkedHours) {

        return ResponseEntity.ok().body(service.addHours(addWorkedHours));

    }

    @PostMapping("/api/service2/totalHours")
    public ResponseEntity<WorkedHoursResponse> totalHours(@RequestBody WorkedHoursDTO workedHoursDTO) {
        return ResponseEntity.ok().body(service.totalWorkedHours(workedHoursDTO));
    }

    @PostMapping("/api/service2/totalPayment")
    public ResponseEntity<EmployeePaymentsResponse> totalPayment(@RequestBody EmployeePaymentsDTO employeePaymentsDTO) {
        return ResponseEntity.ok().body(service.totalPaymentsByEmployee(employeePaymentsDTO));
    }
}
