package Persistance;
import Metier.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

public class Daofiliere{
		Connection con;
		public Daofiliere() throws ClassNotFoundException {
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
public void setfiliere(filiere f){
		  try{
			  
			PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into filiere ( nom_filiere , nom_departement)"
			        	+ "values (? , ? )");
					  st.setString(1, f.getNom_filiere());st.setString(2, f.getNom_departement());
				       st.execute();
			  
			  System.out.println("filiere is save");
              }
		  catch(SQLException ex){
			  ex.printStackTrace();
			  System.err.println("save erreur");
		    }
	}

	public ArrayList<filiere> getAll() {
		ArrayList<filiere> list = new ArrayList<filiere>();
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM filiere");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    String nom_filiere="";
	    String nom_departement="";
		try {
			while(resultat.next())
			{
			    nom_filiere = resultat.getString("nom_filiere");
			    nom_departement = resultat.getString("nom_departement");
			    
			    list.add(new filiere(nom_filiere , nom_departement));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}

	public filiere getfiliere(String s){
		filiere f;
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM filiere where "
					+ "nom_filiere = " + "'s'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	    String nom_filiere="";
	    String nom_departement="";
	   
		boolean isEmpty=false;
		try {
			while(resultat.next())
			{
			    isEmpty=true;
				nom_filiere = resultat.getString("nom");
			    nom_departement = resultat.getString("prenom");
			    
			    
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(isEmpty){
			f = new filiere(nom_filiere, nom_departement);
			return f;
		}
		else return null;
	}
	public boolean delete(filiere fi){
		try { 
			
			     PreparedStatement st;
				    st = (PreparedStatement) con.prepareStatement("delete from filiere where nom_filiere = ?");
				    st.setString(1, fi.getNom_filiere());
				    st.execute();
				    return true;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
	  }
	 }


	}







