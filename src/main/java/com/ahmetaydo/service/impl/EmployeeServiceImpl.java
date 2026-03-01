package com.ahmetaydo.service.impl;

import com.ahmetaydo.dto.DtoDepartment;
import com.ahmetaydo.dto.DtoEmployee;
import com.ahmetaydo.exception.BaseException;
import com.ahmetaydo.exception.ErrorMessage;
import com.ahmetaydo.exception.MessageType;
import com.ahmetaydo.model.Department;
import com.ahmetaydo.model.Employee;
import com.ahmetaydo.repository.EmployeeRepository;
import com.ahmetaydo.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(Long id) {

        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();

        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
        }
        Employee employee = optional.get();
        Department department = employee.getDepartment();

        BeanUtils.copyProperties(employee,dtoEmployee);
        BeanUtils.copyProperties(department,dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);

        return dtoEmployee;
    }
}
