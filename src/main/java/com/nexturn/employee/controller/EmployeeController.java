
package com.nexturn.employee.controller;

import com.nexturn.employee.entity.Employee;
import com.nexturn.employee.service.EmployeeServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

   
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

   
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

 
    @GetMapping("/{empCode}")
    public ResponseEntity<Employee> findByCode(
            @PathVariable String empCode) {

        Employee employee = employeeService.findByCode(empCode);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

  
    @PutMapping("/{empCode}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable String empCode,
            @RequestBody Employee updatedEmployee) {

        Employee employee =
                employeeService.updateEmployee(empCode, updatedEmployee);

        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }


    @DeleteMapping("/{empCode}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable String empCode) {

        boolean deleted = employeeService.deleteEmployee(empCode);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
