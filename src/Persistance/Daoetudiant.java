package Persistance;
import Metier.*;
import Metier.etudiant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class Daoetudiant {
	Connection con;
	public Daoetudiant() throws ClassNotFoundException {
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
public void setetudiant(etudiant e){
	  try{
		  if(e.getId()!=null) {
		  PreparedStatement st = (PreparedStatement) con.prepareStatement("update etudiant set nom = ? ,prenom = ? ,"
		  		+ "email = ?, nom_filiere =? ,niveau = ? ,password =?  where id = '"+e.getId()+"'");
		  st.setString(1, e.getName());st.setString(2, e.getPrenom());st.setString(3, e.getEmail());
		  st.setString(4, e.getFiliere());st.setString(5, e.getNiveau());st.setString(6, e.getPassword());
		  
		  st.execute();
		  }
		  else {
			  PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into etudiant (nom, prenom ,email , nom_filiere , niveau , password)"
		        		+ "values (? , ? , ? , ? , ? ,?)");
				  st.setString(1, e.getName());st.setString(2, e.getPrenom());st.setString(3, e.getEmail());
				  st.setString(4, e.getFiliere());st.setString(5, e.getNiveau());st.setString(6, e.getPassword());
				  st.execute();
			  
		  }
		  System.out.println("etudiant is save");
	  }
	  catch(SQLException ex){
		  ex.printStackTrace();
		  System.err.println("save erreur");
	  }
}

public ArrayList<etudiant> getAll() {
	ArrayList<etudiant> list = new ArrayList<etudiant>();
	ResultSet resultat = null;
	try {
		resultat = this.con.createStatement().executeQuery("SELECT * FROM etudiant");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	Integer id =null;
    String nom="";
    String prenom="";
    String email="";
    String filiere="";
    String niveau="";
    String password="";
	try {
		while(resultat.next())
		{   
			id = resultat.getInt("id");
		    nom = resultat.getString("nom");
		    prenom = resultat.getString("prenom");
		    email = resultat.getString("email");
		    filiere= resultat.getString("nom_filiere");
		    niveau= resultat.getString("niveau");
		    password=resultat.getString("password");
		    list.add(new etudiant(id,nom, prenom, email, filiere, niveau ,password));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	}

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
}





