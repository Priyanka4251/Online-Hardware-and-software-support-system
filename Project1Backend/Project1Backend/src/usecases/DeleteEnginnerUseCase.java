package usecases;

import java.util.Scanner;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import exceptions.EngineerException;

public class DeleteEnginnerUseCase {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter here engineer name to delete ");
		String name = sc.next();
	
	   EngineerDao deo = new EngineerDaoImpl();
	   
	   String result;
	   
	try {
		result = deo.deleteEngineer(name);
		System.out.println(result);
	} catch (EngineerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
		
	}
		
		
		
	}
