package deo;

import bean.bean.Hod;
import exceptions.HodException;

public interface HodDao {

	public String loginHod(String username, String password)throws HodException;

	
}
