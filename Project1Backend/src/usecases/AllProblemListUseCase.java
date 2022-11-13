package usecases;

import java.util.List;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImlp;
import DAO.ProblemDao;
import DAO.ProblemDaoImpl;
import bean.bean.Employee;
import bean.bean.Problem;
import exceptions.EmployeeException;
import exceptions.ProblemException;

public class AllProblemListUseCase {

public static void main(String[] args) {
		
		
		ProblemDao dao=new ProblemDaoImpl();
		
		
		try {
			
			List<Problem> problems=dao.getAllProblemList();
//			problems.forEach(s -> System.out.println(s));
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
