package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.Exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeModel addemployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = new EmployeeModel(employeeDTO);
        employeeModel.setRegisteredDate(LocalDateTime.now());
        employeeRepository.save(employeeModel);
        return employeeModel;
    }

    @Override
    public EmployeeModel updateemployee(long id, EmployeeDTO employeeDTO) {

        Optional<EmployeeModel> isEmployeepresent = employeeRepository.findById(id);
         if (isEmployeepresent.isPresent()){
             isEmployeepresent.get().setFirstName(employeeDTO.getFirstName());
             isEmployeepresent.get().setLastName(employeeDTO.getLastName());
             isEmployeepresent.get().setCompanyName(employeeDTO.getCompanyName());
             isEmployeepresent.get().setSalary(employeeDTO.getSalary());
             isEmployeepresent.get().setDepartment(employeeDTO.getDepartment());
             isEmployeepresent.get().setUpadateDate(LocalDateTime.now());

             employeeRepository.save(isEmployeepresent.get());
             return isEmployeepresent.get();
         }

        throw new EmployeeNotFoundException(400, "Employee not present");
    }

    @Override
    public List<EmployeeModel> getEmpdata() {
        List<EmployeeModel> getallemployee = employeeRepository.findAll();
        if (getallemployee.size()>0)
            return getallemployee;
        else
            throw new EmployeeNotFoundException(400, "No Data Present");
    }

    @Override
    public EmployeeModel deleteemployee(Long id) {
        Optional<EmployeeModel> isEmpployeepresent = employeeRepository.findById(id);
        if(isEmpployeepresent.isPresent()){
            employeeRepository.delete(isEmpployeepresent.get());
            return isEmpployeepresent.get();
        }
        throw new EmployeeNotFoundException(400, "Employee not present");
    }

}
