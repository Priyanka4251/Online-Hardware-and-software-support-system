package DAO;

import java.util.List;


import bean.bean.Engineer;
import bean.bean.Problem;
import exceptions.EngineerException;
import exceptions.ProblemException;

public interface ProblemDao {

	public String CreateProblem(Problem problem);
	
	public List<Problem> getAllProblemList()throws ProblemException;
	
	public String updateStatus(String sts,int id) throws ProblemException;
	
//	public String getAssignProblemList(String pname)throws ProblemException;
	
//	public String changePassword(String username, String password, String newpassword) throws ProblemException;
}
