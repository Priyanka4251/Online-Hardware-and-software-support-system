package usecases;

import java.util.List;


import bean.bean.Employee;
import bean.bean.Problem;
import deo.EmployeeDao;
import deo.EmployeeDaoImlp;
import deo.ProblemDao;
import deo.ProblemDaoImpl;
import exceptions.EmployeeException;
import exceptions.ProblemException;

public class AllProblemListUseCase {

public static void main(String[] args) {
		
		
		ProblemDao dao=new ProblemDaoImpl();
		
		
		try {
			
			List<Problem> problems=dao.getAllProblemList();
			problems.forEach(e -> {
				
				System.out.println("Problem id is : "+e.getPid());
				System.out.println("Problem name is : "+e.getPname());
				System.out.println("Problem category is : "+e.getPcategory());
				System.out.println("Problem status is : "+e.getPstatus());
				
				
				
				System.out.println("=================================");
				
			});
			
		} catch (ProblemException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
}
