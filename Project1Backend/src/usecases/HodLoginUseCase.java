package usecases;

import java.util.Scanner;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import DAO.HodDao;
import DAO.HodDaoImpl;
import bean.bean.Engineer;
import bean.bean.Hod;
import exceptions.EngineerException;
import exceptions.HodException;

public class HodLoginUseCase {

	public static void main(String[] args) {
		
		 Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter Username:");
			String username = sc.next();
			
			System.out.println("Enter Password:");
			String password = sc.next();
			
			HodDao dao=new HodDaoImpl();
			
			try {
				String hod= dao.loginHod(username, password);
			
		 		System.out.println("Login succesfull.... :");
		 	
		 	
			}catch (HodException e) {
				System.out.println(e.getMessage());
			}
		
	}
}
