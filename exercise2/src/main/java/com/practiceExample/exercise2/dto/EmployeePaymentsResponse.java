package com.practiceExample.exercise2.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
        "payment",
        "success"
})
@Getter
@Setter
@NoArgsConstructor
public class EmployeePaymentsResponse extends ApiResponse {

    private double payment;

    public EmployeePaymentsResponse(Boolean success, double payment) {
        super(success);
        this.payment = payment;
    }
}
