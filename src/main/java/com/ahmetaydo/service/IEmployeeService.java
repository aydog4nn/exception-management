package com.ahmetaydo.service;

import com.ahmetaydo.dto.DtoEmployee;
import com.ahmetaydo.model.Employee;

public interface IEmployeeService {

    public DtoEmployee findEmployeeById(Long id);

}
