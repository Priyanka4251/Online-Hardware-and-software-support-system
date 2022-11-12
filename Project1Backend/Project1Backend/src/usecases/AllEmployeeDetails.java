package usecases;

import java.util.List;


import DAO.EmployeeDao;
import DAO.EmployeeDaoImlp;
import bean.bean.Employee;
import exceptions.EmployeeException;

public class AllEmployeeDetails {

	public static void main(String[] args) {
		
		
		EmployeeDao dao=new EmployeeDaoImlp();
		
		
		try {
			
			List<Employee> employees=dao.getEmployeeDetails();
			employees.forEach(s -> System.out.println(s));
			
		} catch (EmployeeException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
