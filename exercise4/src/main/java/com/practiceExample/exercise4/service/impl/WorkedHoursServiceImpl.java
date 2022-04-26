package com.practiceExample.exercise4.service.impl;

import com.practiceExample.exercise4.dto.EmployeeResponse;
import com.practiceExample.exercise4.dto.WorkedHoursDTO;
import com.practiceExample.exercise4.dto.WorkedHoursResponse;
import com.practiceExample.exercise4.exceptions.GenericException;
import com.practiceExample.exercise4.exceptions.ResourceNotFoundException;
import com.practiceExample.exercise4.service.IWorkedHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.practiceExample.exercise4.utils.AppConstants.*;

@Service
public class WorkedHoursServiceImpl implements IWorkedHoursService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public WorkedHoursResponse totalWorkedHours(WorkedHoursDTO workedHoursDTO) {

        try{
            EmployeeResponse response = restTemplate.getForObject(SERVICE1 + "/api/service1/employee/" + workedHoursDTO.getEmployee_id(),EmployeeResponse.class);
            if (!response.isSuccess()){
                throw new ResourceNotFoundException(EMPLOYEE,ID,workedHoursDTO.getEmployee_id());
            }

            if(workedHoursDTO.getStart_date().compareTo(workedHoursDTO.getEnd_date()) > 0 ){
                throw new GenericException(INVALID_DATES);
            }
        }
        catch(HttpClientErrorException e){
            throw new GenericException(e.getMessage());
        }

        WorkedHoursResponse workedHoursResponse;
        try{
            workedHoursResponse = restTemplate.postForObject(SERVICE2 + "/api/service2/totalHours",workedHoursDTO,WorkedHoursResponse.class);
        }catch(HttpClientErrorException e){
            throw new GenericException(e.getStatusText());
        }

        if(!workedHoursResponse.getSuccess()){
            throw new GenericException(EMPLOYEE_WITHOUT_HOURS);
        }

        return workedHoursResponse;
    }
}
