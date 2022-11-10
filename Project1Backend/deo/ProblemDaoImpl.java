package deo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.bean.Problem;
import exceptions.EngineerException;
import exceptions.ProblemException;
import utility.DButil;

public class ProblemDaoImpl implements ProblemDao {

	@Override
	public String CreateProblem(Problem problem) {
		String message="Problem Not Inserted";
		
		
		
		try(Connection conn=DButil.provideConnection()) {
			
		PreparedStatement ps=conn.prepareStatement("insert into Problems(pname,pcategory)values(?,?)");
		
		ps.setString(1, problem.getPname() );
		ps.setString(2, problem.getPcategory());
	
		
		int x= ps.executeUpdate();
		
		if(x>0) message="Problem Added succesfully";
		
		} catch (SQLException e) {
			// TODO: handle exception
			message=e.getMessage();
		}
			
			
			return message;
	}

	@Override
	public List<Problem> getAllProblemList() throws ProblemException {
		List<Problem> problems= new ArrayList<>();
		
		try(Connection conn=DButil.provideConnection()) {
			
		PreparedStatement ps=	conn.prepareStatement("select * from problems");
			
		ResultSet	rs =ps.executeQuery();
		
		while(rs.next()) {
			
			if(rs.next()) {
				
				int id= rs.getInt("pid");
				String n= rs.getString("pname");
				String c= rs.getString("pcategory");
				String s=rs.getString("status");
				
		   Problem	problem=new Problem(id,n,c, s);		
		   problems.add(problem);
		}
			
			
		} }catch (SQLException e) {
			// TODO: handle exception
			
			throw new ProblemException(e.getMessage());
			
		}
		
		if(problems.size()==0) {
			throw new ProblemException("No Problem Found");
		}
		
		return problems;
	}

	@Override
	public String updateStatus(String status, int pid) throws ProblemException {
		
		String message = "Updated";
		
        try(Connection conn= DButil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update problems set status = ? where pid= ?");
			ps.setString(1, status);
			ps.setInt(2, pid);
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Proble Status Updated....";
			}
			
			
        }catch (SQLException e) {
       	 
			throw new ProblemException(e.getMessage());
		}
		
		
		return message;
		
		
	}

	}
