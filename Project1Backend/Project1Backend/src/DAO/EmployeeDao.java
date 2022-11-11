package DAO;

import java.util.List;


import bean.bean.Employee;
import bean.bean.Problem;
import bean.bean.ProblemPro;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.ProblemException;

public interface EmployeeDao {

	
	// register a employee:
	public String registerEmployee(Employee employee);
	
	
	// login a employee
	public Employee loginEmployee(String EmpUserName, String EmpPassword)throws EmployeeException;

	
	// list of employee;
	public List<Employee> getEmployeeDetails()throws EmployeeException;

	public String changePassword(String username, String password, String newpassword) throws EmployeeException;
	
	public List<ProblemPro> getAllDetailsProble(String pname) throws EmployeeException;
	
}
