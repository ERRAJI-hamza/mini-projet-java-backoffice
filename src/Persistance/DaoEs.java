package Persistance;
import Metier.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

public class DaoEs{
			Connection con;
			public DaoEs() throws ClassNotFoundException {
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
	public void setentreprise(entreprise es, int type){
			  try{
				  if(type == 1) {
					  PreparedStatement st = (PreparedStatement) con.prepareStatement("update entreprise set email_Es = ?, tele_Es = ?,responsable_Es = ? where id_Es = '"+es.getId_Es()+"'");
					  st.setString(1, es.getEmail_ES());st.setString(2, es.getTele_ES());st.setString(3, es.getResponsable_Es());
				       st.execute();
					  }
				  else {
				PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into entreprise ( id_Es, email_Es,tele_Es,responsable_Es)"
				        	+ "values (? , ?,?,? )");
						  st.setInt(1, es.getId_Es());st.setString(2, es.getEmail_ES());st.setString(3, es.getTele_ES());st.setString(4, es.getResponsable_Es());
					       st.execute();
				  	              }}
			  catch(SQLException ex){
				  ex.printStackTrace();
				  System.err.println("save erreur");
			    }
		}

	public ArrayList<entreprise> getAll() {
			ArrayList<entreprise> list = new ArrayList<entreprise>();
			ResultSet resultat = null;
			try {
				resultat = this.con.createStatement().executeQuery("SELECT * FROM entreprise");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Integer id_Es=null;
		    String email_Es="";
		    String tele_Es="";
		    String responsable_Es="";
			try {
				while(resultat.next())
				{
				    id_Es = resultat.getInt("id_Es");
				    email_Es= resultat.getString("email_ES");
				    tele_Es =resultat.getString("tele_Es");
				    responsable_Es=resultat.getString("responsable_Es");
				    
				    list.add(new entreprise(id_Es , email_Es,tele_Es,responsable_Es));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
			}

		public entreprise getdepartement(Integer id){
			entreprise es;
			ResultSet resultat = null;
			try {
				resultat = this.con.createStatement().executeQuery("SELECT * FROM entreprise where "
						+ "id_Es = " + "'id'");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			Integer id_Es=null;
		    String email_Es="";
		    String tele_Es="";
		    String responsable_Es="";
			boolean isEmpty=false;
			try {
				while(resultat.next())
				{
				    isEmpty=true;
				    id_Es = resultat.getInt("id_Es");
				    email_Es= resultat.getString("email_ES");
				    tele_Es =resultat.getString("tele_Es");
				    responsable_Es=resultat.getString("responsable_Es");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			if(isEmpty){
				es = new entreprise(id_Es , email_Es,tele_Es,responsable_Es);
				return es;
			}
			else return null;
		}
		public boolean delete(entreprise etp){
			try { 
				
				     PreparedStatement st;
					    st = (PreparedStatement) con.prepareStatement("delete from entreprise where id_Es = ?");
					    st.setInt(1, etp.getId_Es());
					    st.execute();
					    return true;
				} catch (SQLException ex) {
					ex.printStackTrace();
					return false;
		  }
		 }



}

