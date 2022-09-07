package Persistance;
import Metier.*;

import java.sql.*;
import java.util.*;
import com.mysql.jdbc.PreparedStatement;

public class Daorendez{
		Connection con;
		public Daorendez() throws ClassNotFoundException {
			try {
			Class.forName("com.mysql.jdbc.Driver");
	        DriverManager.registerDriver(
	            new com.mysql.jdbc.Driver());
			con = Connexion.getConnexion();
			}
			catch(SQLException ex){
				ex.getMessage();
			}
		}
	public void setrendez(rendez p){
		  try{
			
				  PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into rendez_vous (date_rv,heure_rv,id,id_prof)"
			        		+ "values ( ? , ? , ? , ?)");
				  st.setString(1, p.getDate());st.setString(2, p.getHeur());
				  st.setInt(3, p.getId());st.setInt(4, p.getId_prof());
				  st.execute();
			  
			  System.out.println("rendez is save");
		  }
		  catch(SQLException ex){
			  ex.printStackTrace();
			  System.err.println("save erreur");
		  }
	}

	public ArrayList<rendez> getAll() {
		ArrayList<rendez> list = new ArrayList<rendez>();
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM rendez_vous");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Integer id_rendez=null;
	    String date="";
	    String heure="";
	    Integer id=null;
	    Integer id_prof=null;
	    try {
			while(resultat.next())
			{   
				id_rendez = resultat.getInt("id_rv");
				date = resultat.getString("date_rv");
				heure = resultat.getString("heure_rv");
				id = resultat.getInt("id");
				id_prof= resultat.getInt("id_prof");
				list.add(new rendez(id_rendez,id_prof,id,date,heure));
			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}}