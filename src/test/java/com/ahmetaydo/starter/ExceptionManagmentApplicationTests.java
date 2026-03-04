package com.ahmetaydo.starter;

import com.ahmetaydo.dto.DtoEmployee;
import com.ahmetaydo.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ExceptionManagmentStarter.class})
class ExceptionManagmentApplicationTests {

		@Autowired
		private IEmployeeService employeeService;

		@Test
		public void testFindEmployeeById(){

			DtoEmployee employee = employeeService.findEmployeeById(2L);
			if (employee != null){
				System.out.println("İsim: " + employee.getName());
			}

		}

}
