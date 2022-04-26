package com.practiceExample.exercise1.service;

import com.practiceExample.exercise1.dto.*;

public interface IEmployeeService {

    ResponseType1 saveEmployee(EmployeeCreateOrUpdateDTO employeeCreateOrUpdateDTO);

    EmployeeResponse findByEmployeeID(Long employeeId);

    EmployeesResponse getEmployeesByJob(GetByJobDTO getByJobDTO);

}
