package Persistance;
import Metier.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

public class Daolabo{
		Connection con;
		public Daolabo() throws ClassNotFoundException {
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
public void setlabo(laboratoire b){
		  try{
			  
			PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into laboratoire ( id_labo , nom_labo , email_labo)"
			        	+ "values (? , ? , ? )");
					  st.setInt(1, b.getId_labo());st.setString(2, b.getNom_labo());st.setString(3, b.getEmail_labo());
				       st.execute();
			  
			  System.out.println("labo is save");
              }
		  catch(SQLException ex){
			  ex.printStackTrace();
			  System.err.println("save erreur");
		    }
	}
public void updatelabo(laboratoire b){
	  try{
		  
		PreparedStatement st = (PreparedStatement) con.prepareStatement("update laboratoire set nom_labo= ?,email_labo = ? where id_labo = '"+b.getId_labo()+"'");
				  st.setString(2, b.getEmail_labo());st.setString(1, b.getNom_labo());
			       st.execute();
		  
		  System.out.println("labo is save");
        }
	  catch(SQLException ex){
		  ex.printStackTrace();
		  System.err.println("save erreur");
	    }
}

	public ArrayList<laboratoire> getAll() {
		ArrayList<laboratoire> list = new ArrayList<laboratoire>();
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM laboratoire");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int id_labo;
	    String nom_labo="";
	    String email_labo="";
		try {
			while(resultat.next())
			{   
				id_labo = resultat.getInt("id_labo");
				nom_labo = resultat.getString("nom_labo");
				email_labo = resultat.getString("email_labo");
			    
			    list.add(new laboratoire(id_labo ,nom_labo, email_labo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}

	public laboratoire getfiliere(int id){
		laboratoire b;
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM laboratoire where "
					+ "id_labo = " + "'id'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		int id_labo=(Integer)null;
	    String nom_labo="";
	    String email_labo="";
	   
		boolean isEmpty=false;
		try {
			while(resultat.next())
			{
			    isEmpty=true;
			    id_labo = resultat.getInt("id_labo");
				nom_labo = resultat.getString("nom_labo");
				email_labo = resultat.getString("email_labo");
			    
			    
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(isEmpty){
			b = new laboratoire(id_labo,nom_labo, email_labo);
			return b;
		}
		else return null;
	}
	public boolean delete(laboratoire l){
		try { 
			
			     PreparedStatement st;
				    st = (PreparedStatement) con.prepareStatement("delete from laboratoire where id_labo = ?");
				    st.setInt(1, l.getId_labo());
				    st.execute();
				    return true;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
	  }
	 }


	}







