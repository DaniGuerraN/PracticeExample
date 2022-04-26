package com.practiceExample.exercise2.service.impl;

import com.practiceExample.exercise2.dto.*;
import com.practiceExample.exercise2.entity.EmployeeWorkedHours;
import com.practiceExample.exercise2.exceptions.GenericException;
import com.practiceExample.exercise2.exceptions.ResourceNotFoundException;
import com.practiceExample.exercise2.repository.IEmployeeWorkedHoursRepository;
import com.practiceExample.exercise2.service.IEmployeeWorkedHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.practiceExample.exercise2.utils.AppConstants.*;

@Service
public class EmployeeWorkedHoursServiceImpl implements IEmployeeWorkedHoursService {

    private final IEmployeeWorkedHoursRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeWorkedHoursServiceImpl(IEmployeeWorkedHoursRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResponseType1 addHours(AddWorkedHours addWorkedHours) {
        try{
            EmployeeResponse response = restTemplate.getForObject(SERVICE1 + "/api/service1/employee/" + addWorkedHours.getEmployeeId(), EmployeeResponse.class);
            if (!response.isSuccess()) {
                throw new ResourceNotFoundException(EMPLOYEE, ID, addWorkedHours.getEmployeeId());
            }
        }catch(HttpClientErrorException e){
            throw new GenericException(e.getMessage());
        }


        if (addWorkedHours.getWorkedHours() > 20) {
            throw new GenericException(HOURS_MAX_ERROR);
        }

        Long id;

        EmployeeWorkedHours employeeWorkedHours = EmployeeWorkedHours.builder()
                .workedHours(addWorkedHours.getWorkedHours())
                .workedDate(addWorkedHours.getWorkedDate())
                .employeeId(addWorkedHours.getEmployeeId())
                .build();
        try {
            id = repository.save(employeeWorkedHours).getId();
        } catch (DataIntegrityViolationException e) {
            throw new GenericException(DUPLICATE_RECORD);
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }

        ResponseType1 responseType1 = new ResponseType1(true, id);
        return responseType1;

    }

    @Override
    public WorkedHoursResponse totalWorkedHours(WorkedHoursDTO workedHoursDTO) {


        Integer integer = repository.totalHoursByDates(workedHoursDTO.getEmployee_id(), workedHoursDTO.getStart_date(), workedHoursDTO.getEnd_date());
        if (integer == null) {
            throw new GenericException(EMPLOYEE_WITHOUT_HOURS);
        }
        return new WorkedHoursResponse(true, integer);
    }


    @Override
    public EmployeePaymentsResponse totalPaymentsByEmployee(EmployeePaymentsDTO employeePaymentsDTO) {
        Integer integer = repository.totalPaymentHours(employeePaymentsDTO.getEmployee_id(), employeePaymentsDTO.getStart_date(), employeePaymentsDTO.getEnd_date());
        if (integer == null) {
            throw new GenericException(EMPLOYEE_WITHOUT_HOURS);
        }
        return new EmployeePaymentsResponse(true, integer);
    }
}
