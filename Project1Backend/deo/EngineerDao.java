package deo;
import java.util.List;


import bean.bean.Employee;
import bean.bean.Engineer;
import bean.bean.EngineerDTO;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.ProblemException;

public interface EngineerDao {

	public String registerEngineer(Engineer engineer);
	
	public Engineer loginEngineer(String EngUserName, String EngPass)throws EngineerException;
	
	public List<Engineer> getEngineersDetail()throws EngineerException;

	public String assigningProblemToEngineer(int pid, int engId) throws EngineerException, ProblemException;

	 // Assigning a problem to engineer;
//     public String assigningProblemToEngineer(int pid,int engId) throws EngineerException,ProblemException;
	
	
	public List<EngineerDTO> getAlEnginnerAssignProblem(String pname)throws ProblemException;

	public String deleteEngineer(String name) throws EngineerException;

	public String changePassword(String username, String password, String newpassword) throws EngineerException;
	
}


//mysql> create table Engineer(
//	    -> EngId int primary key auto_increment,
//	    -> EngName varchar(15),
//	    -> EngUserName varchar(15),
//	    -> EngPass varchar(15),
//	    -> EngCategory varchar(20)
//	    -> );
//	Query OK, 0 rows affected (0.05 sec)