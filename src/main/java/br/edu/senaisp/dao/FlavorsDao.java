package br.edu.senaisp.dao;

import java.sql.Connection;
import br.edu.senaisp.model.Flavor;

public class FlavorsDao {
	
	
	public void insert(Flavor flavor) {
		
		try {
			Connection con = Dao.initializeDatabase();
			
			System.out.print(con.isClosed());
			
			
		} catch (Exception e) {
			System.out.print("ClassNotFoundException");
			
		}
		
	}
	
	

}
