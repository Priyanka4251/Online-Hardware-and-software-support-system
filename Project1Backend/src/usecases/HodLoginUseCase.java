package com.project.usecases;

import java.util.Scanner;

import com.project.bean.Engineer;
import com.project.bean.Hod;
import com.project.deo.EngineerDao;
import com.project.deo.EngineerDaoImpl;
import com.project.deo.HodDao;
import com.project.deo.HodDaoImpl;
import com.project.exceptions.EngineerException;
import com.project.exceptions.HodException;

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
