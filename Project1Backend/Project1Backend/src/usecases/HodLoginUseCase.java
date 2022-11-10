package usecases;

import java.util.Scanner;


import bean.bean.Engineer;
import bean.bean.Hod;
import deo.EngineerDao;
import deo.EngineerDaoImpl;
import deo.HodDao;
import deo.HodDaoImpl;
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
