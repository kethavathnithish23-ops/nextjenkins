package com.nexturn.employee.entity;

public class Employee {
	private String empCode;
	private String empName;
	private double salary;
	 public Employee() {}

	    public Employee(String empCode, String empName, double salary) {
	        this.empCode = empCode;
	        this.empName = empName;
	        this.salary = salary;
	    }
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
