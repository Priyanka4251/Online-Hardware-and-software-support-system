package DAO;

import java.util.List;


import bean.bean.Employee;
import bean.bean.Problem;
import bean.bean.Problem2;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.ProblemException;

public interface EmployeeDao {

	public String registerEmployee(Employee employee);
	
	public Employee loginEmployee(String EmpUserName, String EmpPassword)throws EmployeeException;
	
	public List<Employee> getEmployeeDetails()throws EmployeeException;

	public String changePassword(String username, String password, String newpassword) throws EmployeeException;
	
	public List<Problem2> getAllDetailsProble(String pname) throws EmployeeException;
	
}
