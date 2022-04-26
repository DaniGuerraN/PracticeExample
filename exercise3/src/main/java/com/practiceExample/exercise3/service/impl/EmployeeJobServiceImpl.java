package com.practiceExample.exercise3.service.impl;

import com.practiceExample.exercise3.dto.EmployeeResponse;
import com.practiceExample.exercise3.dto.EmployeesResponse;
import com.practiceExample.exercise3.dto.GetByJobDTO;
import com.practiceExample.exercise3.dto.JobResponse;
import com.practiceExample.exercise3.entity.foreingEntities.Employee;
import com.practiceExample.exercise3.exceptions.GenericException;
import com.practiceExample.exercise3.exceptions.ResourceNotFoundException;
import com.practiceExample.exercise3.service.IEmployeeJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.practiceExample.exercise3.utils.AppConstants.*;
@Service
public class EmployeeJobServiceImpl implements IEmployeeJobService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String allEmployeesByJob(GetByJobDTO getByJobDTO) {

        String str;
        try{
            str = restTemplate.postForObject(SERVICE1 + "/api/service1/employeesByJob" ,getByJobDTO,String.class);
        }catch(HttpClientErrorException e){
            throw new GenericException(e.getStatusText());
        }

        return str;
    }

}
