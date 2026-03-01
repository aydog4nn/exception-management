package com.ahmetaydo.controller;

import com.ahmetaydo.dto.DtoEmployee;

public interface RestEmployeeController {

    public DtoEmployee findEmployeeById(Long id);

}
