package usecases;

import java.util.Scanner;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import DAO.ProblemDao;
import DAO.ProblemDaoImpl;
import exceptions.EngineerException;
import exceptions.ProblemException;

public class UpdatePasswordToEngineerUseCase {

	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a username");
		String username= sc.next();
		
		System.out.println("Enter a password");
		String password= sc.next();
		
		System.out.println("Enter a new password");
		String newpassword= sc.next();
		
		EngineerDao deo8 = new EngineerDaoImpl();
		
		try {
			String changepass = deo8.changePassword(username, password, newpassword);
			System.out.println(changepass);
			
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
