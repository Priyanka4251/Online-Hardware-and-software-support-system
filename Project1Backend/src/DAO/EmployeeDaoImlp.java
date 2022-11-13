package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.exceptions.RSAException;
import bean.bean.Employee;
import bean.bean.Engineer;
import bean.bean.EngineerDTO;
import bean.bean.Problem2;
import exceptions.EmployeeException;
import exceptions.EngineerException;
import exceptions.ProblemException;
import utility.DButil;

public class EmployeeDaoImlp implements EmployeeDao {
	
	@Override
	public String registerEmployee(Employee employee) {
	
		String message="Not Inserted";
		
	
	
	try(Connection conn=DButil.provideConnection()) {
		
	PreparedStatement ps=conn.prepareStatement("insert into Employee(empName,empUserName,empPassword) values(?,?,?)");
	
	ps.setString(1, employee.getEmpName() );
	ps.setString(2, employee.getEmpUserName());
	ps.setString(3, employee.getEmpPassword());
	
	int x= ps.executeUpdate();
	
	if(x>0) message="Employee Registration succesfully";
	
	} catch (SQLException e) {
		// TODO: handle exception
		message=e.getMessage();
	}
		
		
		return message;
	}

	@Override
	public Employee loginEmployee(String EmpUserName, String EmpPassword) throws EmployeeException {
		
		Employee employee=null;
		
		
		try(Connection conn= DButil.provideConnection() ){
		
		PreparedStatement ps =conn.prepareStatement("select * from Employee where empUserName=? AND empPassword=?");
		
		ps.setString(1, EmpUserName);
		ps.setString(2, EmpPassword);
		
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			
			int id= rs.getInt("empID");
			String n= rs.getString("empName");
			String e= rs.getString("empUserName");
			String p= rs.getString("empPassword");
			
			
		employee=new Employee(id,n,e,p);	
			
			
		}else
			throw new EmployeeException("Invalid Username or password.. ");
		
		
		
		
	} catch (SQLException e) {
		throw new EmployeeException(e.getMessage());
	}


	return employee;
	
	}

	@Override
	public List<Employee> getEmployeeDetails() throws EmployeeException {
	
		
		List<Employee> employees= new ArrayList<>();
		
		try(Connection conn=DButil.provideConnection()) {
			
		PreparedStatement ps=	conn.prepareStatement("select * from employee");
			
		 ResultSet	rs =ps.executeQuery();
		
		while(rs.next()) {
			
			int id= rs.getInt("empID");
			String n= rs.getString("empName");
			String e= rs.getString("empUserName");
			String p= rs.getString("empPassword");
			
			
		   Employee employee=new Employee(id,n,e,p);	
		   employees.add(employee);
		}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			throw new EmployeeException(e.getMessage());
			
		}
		
		if(employees.size()==0) {
			throw new EmployeeException("No Employee Found");
		}
		
		return employees;
		
	}

	@Override
	public String changePassword(String username, String password, String newpassword) throws EmployeeException {

		String message = "Password Not Updated";
		
        try(Connection conn = DButil.provideConnection()) {
		
		
		PreparedStatement ps= conn.prepareStatement("update employee set emppassword= ? where empUserName= ? AND empPassword= ? ");			
		
		ps.setString(1, newpassword);
		ps.setString(2, username);
		ps.setString(3, password);
		
		int x = ps.executeUpdate();
		
		if(x>0) {
			
			message = "Your password change successfully !";
		}
		else {
			
			throw new EmployeeException("Invalid Username or password.. ");
			
		}
		
    } catch (SQLException e) {
		throw new  EmployeeException(e.getMessage());
	}
	
	
	
	return message;
	}

	@Override
	public List<Problem2> getAllDetailsProble(String pname) throws EmployeeException {


        List<Problem2> list= new ArrayList<>();
		
		try(Connection conn=DButil.provideConnection()) {
			
		PreparedStatement ps=conn.prepareStatement("select e.engid,p.pid, e.engname,p.pname,e.engcategory,p.status from engineer e INNER JOIN problems p INNER JOIN employee_engineer ee ON e.engid=ee.reid AND p.pid=ee.rpid AND p.pname =?;");
		ps.setString(1, pname);	
		ResultSet	rs =ps.executeQuery();
		
		while(rs.next()) {
			
			if(rs.next()) {
				
				int eid= rs.getInt("engid");
				int pid= rs.getInt("pid");
				String n= rs.getString("engname");
				String pn=rs.getString("pname");
				String c= rs.getString("engcategory");
				String s=rs.getString("status");
				
		   Problem2	problem=new Problem2(eid, pid,n,pn, c, s);		
		   list.add(problem);
		}
			
			
		} }catch (SQLException e) {
			// TODO: handle exception
			
			throw new EmployeeException(e.getMessage());
			
		}
		
		if(list.size()==0) {
			throw new EmployeeException("No Problem Found");
		}
		
		return list;
	}


	public String assigningProblemToEngineer(int pid, int engId) throws EngineerException, ProblemException{
		
String message = "Engineer Not found";
		
        try(Connection conn = DButil.provideConnection()) {
		
		
		PreparedStatement ps= conn.prepareStatement("insert into emp_engg(rpid,reid) values(?,?)");
		
		ps.setInt(1, pid);
		ps.setInt(2, engId);
		
		int x = ps.executeUpdate();
		
		if(x>0) {
			
			message = "Your password change successfully !";
		}
		else {
			
			throw new EngineerException("Invalid engineerID or ProblemID.. ");
			
		}
		
    } catch (SQLException e) {
		throw new  EngineerException(e.getMessage());
	}
	
	
	
	return message;
		
	}




	
}	
