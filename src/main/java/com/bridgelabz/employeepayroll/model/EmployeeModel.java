package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employee")
@Data
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeid;
    private String firstName;
    private String lastName;
    private String companyName;
    private int salary;
    private String department;
    private LocalDateTime registeredDate;
    private LocalDateTime upadateDate;


    public EmployeeModel(EmployeeDTO employeeDTO){
        this.firstName=employeeDTO.getFirstName();
        this.lastName=employeeDTO.getLastName();
        this.companyName=employeeDTO.getCompanyName();
        this.salary=employeeDTO.getSalary();
        this.department=employeeDTO.getDepartment();
        this.registeredDate=LocalDateTime.now();
    }

    public EmployeeModel() {

    }
}
