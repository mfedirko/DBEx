package model;

import java.util.Date;

public class Employee {

	private static Employee instance = new Employee();

	public static Employee newInstance() {
		return instance;
	}
	

	private int empId;
	private String empName;
	private Date dob;
	private double salary;
	private int deptId;
	
public Employee(){}
	
public Employee(int empId,String empName,Date dob,double salary,int deptId) {
		this.empId=empId;
		this.empName=empName;
		this.dob=dob;
		this.salary=salary;
		this.deptId=deptId;
	}

	// getters and setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

}