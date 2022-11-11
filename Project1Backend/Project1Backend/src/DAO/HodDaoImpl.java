package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.HodException;
import utility.DButil;

public class HodDaoImpl implements HodDao{
	@Override
	public String loginHod(String username, String password) throws HodException {
   
		String message = "login failed";
		
        try(Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from hod where username = ? AND password = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet x = ps.executeQuery();
			
			if(x.next()) {
				message = "Login Successful!";
			}else {
				throw new HodException("Invalid Username or Password, Check once... ");
			}
        } catch (SQLException e) {
			throw new HodException(e.getMessage());
		}
		return message;
	}
}
