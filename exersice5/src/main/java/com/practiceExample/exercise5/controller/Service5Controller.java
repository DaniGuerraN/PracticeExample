package com.practiceExample.exercise5.controller;

import com.practiceExample.exercise5.dto.EmployeePaymentsDTO;
import com.practiceExample.exercise5.dto.EmployeePaymentsResponse;
import com.practiceExample.exercise5.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service5Controller {


    private final PaymentServiceImpl service;

    @Autowired
    public Service5Controller(PaymentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/api/service5/totalPayment")
    public ResponseEntity<EmployeePaymentsResponse> totalPayment(@RequestBody EmployeePaymentsDTO employeePaymentsDTO) {
        return ResponseEntity.ok().body(service.paymentsByEmployee(employeePaymentsDTO));
    }

}
