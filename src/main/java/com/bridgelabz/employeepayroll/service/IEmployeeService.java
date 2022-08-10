package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {
    EmployeeModel addemployee(EmployeeDTO employeeDTO);

    EmployeeModel updateemployee(long id, EmployeeDTO employeeDTO);

    List<EmployeeModel> getEmpdata();

    EmployeeModel deleteemployee(Long id);
}
