
package com.nexturn.employee.service;

import com.nexturn.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl {

    private final List<Employee> employees = new ArrayList<>();

    
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    
    public List<Employee> findAll() {
        return employees;
    }

   
    public Employee findByCode(String empCode) {
        for (Employee employee : employees) {
            if (employee.getEmpCode().equals(empCode)) {
                return employee;
            }
        }
        return null;
    }

   
    public Employee updateEmployee(String empCode, Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getEmpCode().equals(empCode)) {
                employee.setEmpName(updatedEmployee.getEmpName());
                employee.setSalary(updatedEmployee.getSalary());
                return employee;
            }
        }
        return null;
    }

    
    public boolean deleteEmployee(String empCode) {
        return employees.removeIf(
            employee -> employee.getEmpCode().equals(empCode)
        );
    }
}
