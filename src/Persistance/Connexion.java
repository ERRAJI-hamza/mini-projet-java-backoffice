package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
	 final static String driverClassName="com.mysql.jdbc.Driver";
	 final static String connectionUrl="jdbc:mysql://localhost:3306/project_java?"
	 		+ "characterEncoding=latin1&useConfigs=maxPerformance";
	 
	 public Connexion(){
		
	 }
	 public static Connection getConnexion(){
		 Connection con=null;
		  try {
			  
			  con = DriverManager.getConnection(connectionUrl, "root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return con;
	 }
}
