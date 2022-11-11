package usecases;

import java.util.Scanner;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import bean.bean.Engineer;

public class RegisterEngineerUseCase1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Engineer Name:");
		String EngName= sc.next();
		
		System.out.println("Enter Engineer User Name:");
		String EngUserName = sc.next();
		
		System.out.println("Enter Engineer password:");
		String EngPassword= sc.next();
		
		System.out.println("Enter Engineer Category :");
		String EngCategory= sc.next();
		
		EngineerDao dao=new EngineerDaoImpl();
		
		
		Engineer engineer=new Engineer();
		
		engineer.setEngName(EngName);
		engineer.setEngUserName(EngUserName);
		engineer.setEngPass(EngPassword);
		engineer.setEngCategory(EngCategory);
		
		
		String result=dao.registerEngineer(engineer);
		System.out.println(result);
		sc.close();
	}
}
