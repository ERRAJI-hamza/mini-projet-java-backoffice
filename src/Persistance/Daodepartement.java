package Persistance;
import Metier.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

public class Daodepartement{
			Connection con;
			public Daodepartement() throws ClassNotFoundException {
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
			public void setdepartement(departement d,int i){
				  try{
					  if(i==1) {
						  PreparedStatement st = (PreparedStatement) con.prepareStatement("update departement set email_departement = ? where nom_departement = ?");
						  st.setString(1, d.getEmail_departement());
						  st.setString(2, d.getNom_departement());
							
						  st.execute();
						  }
					  else {
					PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into departement ( nom_departement , email_departement)"
					        	+ "values (? , ? )");
							  st.setString(1, d.getNom_departement());st.setString(2, d.getEmail_departement());
						       st.execute();
					  
					  System.out.println("departement is save");
		              }}
				  catch(SQLException ex){
					  ex.printStackTrace();
					  System.err.println("save erreur");
				    }
			}

	public ArrayList<departement> getAll() {
			ArrayList<departement> list = new ArrayList<departement>();
			ResultSet resultat = null;
			try {
				resultat = this.con.createStatement().executeQuery("SELECT * FROM departement");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    String nom_departement="";
		    String email_departement="";
			try {
				while(resultat.next())
				{
				    nom_departement = resultat.getString("nom_departement");
				    email_departement= resultat.getString("email_departement");
				    
				    list.add(new departement(nom_departement , email_departement));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
			}

		public departement getdepartement(String s){
			departement d;
			ResultSet resultat = null;
			try {
				resultat = this.con.createStatement().executeQuery("SELECT * FROM departement where "
						+ "nom_departement = " + "'s'");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		    String nom_departement="";
		    String email_departement="";
			boolean isEmpty=false;
			try {
				while(resultat.next())
				{
				    isEmpty=true;
					nom_departement = resultat.getString("nom_departement");
				    email_departement = resultat.getString("email_departement");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			if(isEmpty){
				d = new departement( nom_departement , email_departement);
				return d;
			}
			else return null;
		}
		public boolean delete(departement dp){
			try { 
				
				     PreparedStatement st;
					    st = (PreparedStatement) con.prepareStatement("delete from departement where nom_departement = ?");
					    st.setString(1, dp.getNom_departement());
					    st.execute();
					    return true;
				} catch (SQLException ex) {
					ex.printStackTrace();
					return false;
		  }
		 }


}


