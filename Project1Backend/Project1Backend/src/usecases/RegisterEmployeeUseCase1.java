package usecases;
import java.util.Scanner;

import bean.bean.Employee;
import deo.EmployeeDaoImlp;


public class RegisterEmployeeUseCase1 {

	public static void main(String[] args) {
		
        Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Employee Name:");
		String EmpName= sc.next();
		
		System.out.println("Enter Employee User Name:");
		String EmpUserName = sc.next();
		
		System.out.println("Enter Employee password:");
		String EmpPassword= sc.next();
		
		EmployeeDaoImlp dao=new EmployeeDaoImlp();
		
		
	    Employee employee =new Employee();
		
	    employee.setEmpName(EmpName);
	    employee.setEmpUserName(EmpUserName);
	    employee.setEmpPassword(EmpPassword);
		
		
		String result=dao.registerEmployee(employee);
		System.out.println(result);

		
	}

}
