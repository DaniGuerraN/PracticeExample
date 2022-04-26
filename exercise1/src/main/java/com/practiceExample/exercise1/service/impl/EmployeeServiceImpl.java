package com.practiceExample.exercise1.service.impl;

import com.practiceExample.exercise1.dto.*;
import com.practiceExample.exercise1.entity.Employee;
import com.practiceExample.exercise1.entity.Gender;
import com.practiceExample.exercise1.entity.Job;
import com.practiceExample.exercise1.exceptions.GenericException;
import com.practiceExample.exercise1.exceptions.ResourceNotFoundException;
import com.practiceExample.exercise1.repository.IEmployeeRepository;
import com.practiceExample.exercise1.repository.IGenderRepository;
import com.practiceExample.exercise1.repository.IJobRepository;
import com.practiceExample.exercise1.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.practiceExample.exercise1.utils.AppConstants.*;

@Service
public class EmployeeServiceImpl implements IEmployeeService {


    private final IEmployeeRepository repository;
    private final IJobRepository jobRepository;
    private final IGenderRepository genderRepository;

    @Autowired
    public EmployeeServiceImpl(IEmployeeRepository repository, IJobRepository jobRepository, IGenderRepository genderRepository) {
        this.repository = repository;
        this.jobRepository = jobRepository;
        this.genderRepository = genderRepository;
    }

    @Override
    public ResponseType1 saveEmployee(EmployeeCreateOrUpdateDTO employeeCreateOrUpdateDTO) {
        Gender gender = genderRepository.findById(employeeCreateOrUpdateDTO.getGender_id())
                .orElseThrow(() -> new ResourceNotFoundException(GENDER, ID, employeeCreateOrUpdateDTO.getGender_id()));
        Job job = jobRepository.findById(employeeCreateOrUpdateDTO.getJob_id())
                .orElseThrow(() -> new ResourceNotFoundException(JOB, ID, employeeCreateOrUpdateDTO.getJob_id()));

        Date now = new Date();

        long difference_In_Time
                = Math.abs(now.getTime() - employeeCreateOrUpdateDTO.getBirthdate().getTime());

        long difference_In_Years
                = (difference_In_Time
                / (1000l * 60 * 60 * 24 * 365));
        if (difference_In_Years < 18) {
            throw new GenericException(NO_ENOUGH_AGE);
        }

        Employee employee = Employee.builder()
                .birthdate(employeeCreateOrUpdateDTO.getBirthdate())
                .name(employeeCreateOrUpdateDTO.getName())
                .last_name(employeeCreateOrUpdateDTO.getLast_name())
                .gender(gender)
                .job(job)
                .build();

        Long id;

        try {
            id = repository.save(employee).getId();
        } catch (DataIntegrityViolationException e) {
            throw new GenericException(ERROR_MESSAGE_DUPLICATE);
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }

        ResponseType1 responseType1 = new ResponseType1(true, id);
        return responseType1;
    }


    @Override
    public EmployeeResponse findByEmployeeID(Long employeeId) {
        Employee employee = repository.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE, ID, employeeId));

        return new EmployeeResponse(true, employee);
    }

    @Override
    public EmployeesResponse getEmployeesByJob(GetByJobDTO getByJobDTO) {

        Job job = jobRepository.findById(getByJobDTO.getJob_id())
                .orElseThrow(() -> new ResourceNotFoundException(EMPLOYEE, ID, getByJobDTO.getJob_id()));

        List<Employee> test = job.getEmployees();


        return new EmployeesResponse(true, job.getEmployees());



    }
}
