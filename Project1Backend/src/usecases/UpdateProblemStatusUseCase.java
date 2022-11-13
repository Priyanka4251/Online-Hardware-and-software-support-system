package usecases;

import java.util.Scanner;

import DAO.ProblemDao;
import DAO.ProblemDaoImpl;
import exceptions.ProblemException;

public class UpdateProblemStatusUseCase {

	
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		  
		    System.out.println("Please enter your problem id to update status");
			int prid = sc.nextInt();
			System.out.println("Please enter problem status (resolved/pending) ");
			String statusname = sc.next();
			
			ProblemDao deo = new ProblemDaoImpl();
			
			try {
				String updateresult = deo.updateStatus(statusname, prid);
				
				System.out.println(updateresult);
				
			} catch (ProblemException e) {
				
				e.printStackTrace();
			}


	}
}
