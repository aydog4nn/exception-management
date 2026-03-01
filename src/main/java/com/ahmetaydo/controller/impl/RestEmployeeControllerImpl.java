package com.ahmetaydo.controller.impl;

import com.ahmetaydo.controller.RestEmployeeController;
import com.ahmetaydo.dto.DtoEmployee;
import com.ahmetaydo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControllerImpl implements RestEmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;


    @GetMapping("/list/{id}")
    @Override
    public DtoEmployee findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }
}
