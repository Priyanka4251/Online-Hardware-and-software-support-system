package com.project.usecases;

import java.util.Scanner;
import com.project.bean.Problem;
import com.project.deo.ProblemDao;
import com.project.deo.ProblemDaoImpl;

public class CreateProblemUseCase {

public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Problem  Name:");
		String pname= sc.nextLine();
		
		System.out.println("Enter Problem Category:");
		String pcategory = sc.nextLine();
		
		
		ProblemDao dao=new ProblemDaoImpl();
		
		
		Problem problem=new Problem();
		
		problem.setPname(pname);
		problem.setPcategory(pcategory);
	
		
		
		String result=dao.CreateProblem(problem);
		System.out.println(result);
		sc.close();
	}
	
	
}
