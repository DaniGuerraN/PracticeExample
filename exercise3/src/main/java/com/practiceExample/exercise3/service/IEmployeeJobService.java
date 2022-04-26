package com.practiceExample.exercise3.service;

import com.practiceExample.exercise3.dto.EmployeesResponse;
import com.practiceExample.exercise3.dto.GetByJobDTO;
import com.practiceExample.exercise3.entity.foreingEntities.Employee;

import java.util.List;

public interface IEmployeeJobService {


    String allEmployeesByJob(GetByJobDTO getByJobDTO);

}
