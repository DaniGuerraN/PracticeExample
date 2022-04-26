package com.practiceExample.exercise5.service.impl;

import com.practiceExample.exercise5.dto.EmployeePaymentsDTO;
import com.practiceExample.exercise5.dto.EmployeePaymentsResponse;
import com.practiceExample.exercise5.dto.EmployeeResponse;
import com.practiceExample.exercise5.exceptions.GenericException;
import com.practiceExample.exercise5.exceptions.ResourceNotFoundException;
import com.practiceExample.exercise5.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.practiceExample.exercise5.utils.AppConstants.*;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public EmployeePaymentsResponse paymentsByEmployee(EmployeePaymentsDTO employeePaymentsDTO) {

        try {
            EmployeeResponse response = restTemplate.getForObject(SERVICE1 + "/api/service1/employee/" + employeePaymentsDTO.getEmployee_id(), EmployeeResponse.class);
            if (!response.isSuccess()) {
                throw new ResourceNotFoundException(EMPLOYEE, ID, employeePaymentsDTO.getEmployee_id());
            }

            if (employeePaymentsDTO.getStart_date().compareTo(employeePaymentsDTO.getEnd_date()) > 0) {
                throw new GenericException(INVALID_DATES);
            }
        } catch (HttpClientErrorException e) {
            throw new GenericException(e.getMessage());
        }

        EmployeePaymentsResponse response;
        try {
            response = restTemplate.postForObject(SERVICE2 + "/api/service2/totalPayment", employeePaymentsDTO, EmployeePaymentsResponse.class);
            if (!response.getSuccess()) {
                throw new GenericException(EMPLOYEE_WITHOUT_HOURS);
            }
        } catch (HttpClientErrorException e) {
            throw new GenericException(e.getMessage());
        }


        return response;
    }
}
