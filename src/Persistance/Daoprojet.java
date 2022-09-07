package Persistance;
import Metier.*;

import java.sql.*;
import java.util.*;
import com.mysql.jdbc.PreparedStatement;

public class Daoprojet{
		Connection con;
		public Daoprojet() throws ClassNotFoundException {
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
	public void setprojet(projet p){
		  try{
			  if(p.getId_projet()!=null) {
			  PreparedStatement st = (PreparedStatement) con.prepareStatement("update projet set titre = ? ,date_debut = ? ,"
				  		+ "duree = ?, type =? ,id = ? ,id_prof=?,id_labo =? ,id_ES =? ,encadrant_2=? where id_projet = '"+p.getId_projet()+"'");
			  
			  st.setString(1, p.getTitre());st.setString(2, p.getDate_debut());st.setString(3, p.getDuree());
			  st.setString(4, p.getType());st.setInt(5, p.getId());st.setInt(6, p.getId_prof());
			  st.setInt(7, p.getId_labo());st.setInt(8, p.getId_Es());st.setInt(9, p.getEncadrant_2());
			 
			  st.execute();
			  }
			  else {
				  PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into projet (titre,type,date_debut,duree,id,id_prof,id_labo,id_Es,encadrant_2)"
			        		+ "values ( ? , ? , ? , ? ,?,?,?,?,?)");
				  st.setString(1, p.getTitre());st.setString(2, p.getType());
				  st.setString(3, p.getDate_debut());st.setString(4, p.getDuree());
				  st.setInt(5, p.getId());st.setInt(6, p.getId_prof());
				  st.setInt(7, p.getId_labo());st.setInt(8, p.getId_Es());
				  st.setInt(9, p.getEncadrant_2());st.execute();
				  
			  }
			  System.out.println("projet is save");
		  }
		  catch(SQLException ex){
			  ex.printStackTrace();
			  System.err.println("save erreur");
		  }
	}

	public ArrayList<projet> getAll() {
		ArrayList<projet> list = new ArrayList<projet>();
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM projet");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Integer id_projet=null;
	    String titre="";
	    String date_debut="";
	    String duree="";
	    String type="";
	    Integer id=null;
	    Integer id_prof=null;
	    Integer id_labo=null;
	    Integer id_Es=null;
	    Integer encadrant_2=null;
		try {
			while(resultat.next())
			{   
				id_projet = resultat.getInt("id_projet");
			    titre = resultat.getString("titre");
			    date_debut = resultat.getString("date_debut");
			    duree = resultat.getString("duree");
			    type= resultat.getString("type");
			    id= resultat.getInt("id");
			    id_prof= resultat.getInt("id_prof");
			    id_labo=resultat.getInt("id_labo");
			    id_Es=resultat.getInt("id_Es");
			    encadrant_2=resultat.getInt("encadrant_2");
			    list.add(new projet(id_projet,titre,date_debut,duree,type, id, id_prof ,id_labo,id_Es,encadrant_2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
    /*
	public etudiant getClient(int id){
		etudiant e;
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM etudiant where "
					+ "id = " + "'id'");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	    String nom="";
	    String prenom="";
	    String email="";
	    String filiere="";
	    String niveau="";
	    String password="";
		boolean isEmpty=false;
		try {
			while(resultat.next())
			{
			    isEmpty=true;
				nom = resultat.getString("nom");
			    prenom = resultat.getString("prenom");
			    email = resultat.getString("email");
			    filiere= resultat.getString("filiere");
			    niveau= resultat.getString("niveau");
			    password=resultat.getString("password");
			    
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		if(isEmpty){
			e = new etudiant( nom, prenom, email, filiere, niveau ,password);
			return e;
		}
		else return null;
	}

	public boolean delete(etudiant e){
		try { 
			
			     PreparedStatement st;
				    st = (PreparedStatement) con.prepareStatement("delete from etudiant where ID = ?");
				    st.setInt(1, e.getId());
				    st.execute();
				    return true;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
	  }
	 }
	 */
	}




