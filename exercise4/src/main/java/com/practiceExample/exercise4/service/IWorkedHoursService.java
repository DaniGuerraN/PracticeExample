package com.practiceExample.exercise4.service;

import com.practiceExample.exercise4.dto.WorkedHoursDTO;
import com.practiceExample.exercise4.dto.WorkedHoursResponse;

public interface IWorkedHoursService {

    WorkedHoursResponse totalWorkedHours(WorkedHoursDTO workedHoursDTO);

}
