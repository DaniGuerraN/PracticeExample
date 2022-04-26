package com.practiceExample.exercise2.service;

import com.practiceExample.exercise2.dto.*;

public interface IEmployeeWorkedHoursService {

    ResponseType1 addHours(AddWorkedHours addWorkedHours);

    WorkedHoursResponse totalWorkedHours(WorkedHoursDTO workedHoursDTO);

    EmployeePaymentsResponse totalPaymentsByEmployee(EmployeePaymentsDTO employeePaymentsDTO);
}
