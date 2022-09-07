package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

import Metier.*;

	public class Daoprofesseur{
		Connection con;
		public Daoprofesseur() throws ClassNotFoundException {
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
		public void setprofesseur(professeur p){
			  try{
				  if(p.getId_prof()!=null) {
				  PreparedStatement st = (PreparedStatement) con.prepareStatement("update professeur set nom_prof = ? ,prenom_prof = ? ,"
				  		+ "email_prof = ?, nom_filiere =? ,grade = ? ,nom_departement=?,id_labo =? ,password =? ,role =? where id_prof = '"+p.getId_prof()+"'");
				  st.setString(1, p.getNom_prof());st.setString(2, p.getPrenom_prof());st.setString(3, p.getEmail_prof());
				  st.setString(4, p.getNom_filiere());st.setString(5, p.getGrade());st.setString(6, p.getNom_departement());st.setInt(7, p.getId_labo());
				  st.setString(8, p.getPassword()) ;st.setString(9, p.getRole()) ;
				  st.execute();
				  }
				  else {
					  PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into professeur (nom_prof, prenom_prof ,email_prof, nom_filiere, grade ,nom_departement, id_labo ,password,role)"
				        		+ "values (? , ? , ? , ? , ? ,?,?,?,?)");
						  st.setString(1,p.getNom_prof());st.setString(2, p.getPrenom_prof());st.setString(3, p.getEmail_prof());
						  st.setString(4, p.getNom_filiere());st.setString(5, p.getGrade());st.setString(6, p.getNom_departement());st.setInt(7, p.getId_labo());st.setString(8, p.getPassword()) ;
						  st.setString(9, p.getRole()) ;st.execute();
					  
				  }
				  System.out.println("professeur is save");
			  }
			  catch(SQLException ex){
				  ex.printStackTrace();
				  System.err.println("save erreur");
			  }
		}
		public ArrayList<professeur> getAll() {
		ArrayList<professeur> list = new ArrayList<professeur>();
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM professeur");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Integer id_prof=null;
	    String nom_prof="";
	    String prenom_prof="";
	    String email_prof="";
	    String grade="";
	    Integer id_labo= null;
	    String nom_filiere="";
	    String nom_departement="";
	    String password="";
	    String role="";
	    
		try {
			while(resultat.next())
			{  
				id_prof= resultat.getInt("id_prof");
			    nom_prof = resultat.getString("nom_prof");
			    prenom_prof = resultat.getString("prenom_prof");
			    grade = resultat.getString("grade");
			    email_prof=resultat.getString("email_prof");
			    id_labo = resultat.getInt("id_labo");
			    nom_filiere=resultat.getString("nom_filiere");
			    nom_departement=resultat.getString("nom_departement");
			    password=resultat.getString("password");
			    role=resultat.getString("role");
			    list.add(new professeur(id_prof,nom_prof,prenom_prof,grade,email_prof,id_labo,nom_filiere,nom_departement,password,role));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}
		
		public professeur getprofesseur(Integer a){
			professeur p;
			ResultSet resultat = null;
			try {
				resultat = this.con.createStatement().executeQuery("SELECT * FROM professeur where "
						+ "id_prof = " + "'a'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String nom_prof = null;
			String prenom_prof = null;
			String email_prof = null;
			int id_labo=0;
			String grade=null;
			String nom_filiere=null;
			String nom_departement=null;
			String password=null;
			String role=null;
			
			
			boolean isEmpty=false;
			try {
				while(resultat.next())
				{
				    isEmpty=true;
				    nom_prof = resultat.getString("nom_prof");
				    prenom_prof = resultat.getString("prenom_prof");
				    grade = resultat.getString("grade");
				    email_prof=resultat.getString("email_prof");
				    id_labo = resultat.getInt("id_labo");
				    nom_filiere=resultat.getString("nom_filiere");
				    nom_departement=resultat.getString("nom_departement");
				    password=resultat.getString("password");
				    role=resultat.getString("role");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(isEmpty){
				p = new professeur(nom_prof,prenom_prof,grade,email_prof,id_labo,nom_filiere,nom_departement,password,role);
;
				return p;
			}
			else return null;
		}
		
		public boolean delete(professeur pr){
			try { 
				
				     PreparedStatement st;
					    st = (PreparedStatement) con.prepareStatement("delete from professeur where id_prof = ?");
					    st.setInt(1, pr.getId_prof());
					    st.execute();
					    return true;
				} catch (SQLException ex) {
					ex.printStackTrace();
					return false;
		  }
		 }
	}



