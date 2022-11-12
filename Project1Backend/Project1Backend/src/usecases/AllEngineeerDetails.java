package usecases;

import java.util.List;

import DAO.EngineerDao;
import DAO.EngineerDaoImpl;
import bean.bean.Engineer;
import exceptions.EngineerException;

public class AllEngineeerDetails {

		public static void main(String[] args) {
			
			
			EngineerDao dao=new EngineerDaoImpl();
			try {
				
				List<Engineer> engineer = dao.getEngineersDetail();
				
				engineer.forEach(s -> System.out.println(s));
				
			} catch (EngineerException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
		
	}
		}
}
