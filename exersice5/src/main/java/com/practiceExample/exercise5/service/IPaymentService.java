package com.practiceExample.exercise5.service;

import com.practiceExample.exercise5.dto.EmployeePaymentsDTO;
import com.practiceExample.exercise5.dto.EmployeePaymentsResponse;

public interface IPaymentService {


    EmployeePaymentsResponse paymentsByEmployee(EmployeePaymentsDTO employeePaymentsDTO);

}
