package Persistance;
	import Metier.*;
	import Metier.etudiant;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import com.mysql.jdbc.PreparedStatement;


public class Daodocument {
	
		Connection con;
		public Daodocument() throws ClassNotFoundException {
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
	public void setdocument(document d){
		  try{
			 
				  PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into document(nom_doc,type_doc,id_etape,mot_cle,diposer)"
			        		+ "values ( ? , ? , ?,?,?)");
					  st.setString(1, d.getNom_doc());st.setString(2, d.getType_doc());
					  st.setInt(3, d.getId_etape());st.setString(4, d.getMot_cle());st.setString(5, d.getDiposer());
					  st.execute();
					  
			  System.out.println("document is save");
		  }
		  catch(SQLException ex){
			  ex.printStackTrace();
			  System.err.println("save erreur");
		  }
	}

	public ArrayList<document> getAll() {
		ArrayList<document> list = new ArrayList<document>();
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM document");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Integer id_doc =null;
	    String nom_doc="";
	    String type_doc="";
	    Integer id_etape =null;
	    String mot_cle="";
	    String diposer="";
		try {
			while(resultat.next())
			{   
				id_doc = resultat.getInt("id_doc");
			    nom_doc = resultat.getString("nom_doc");
			    type_doc = resultat.getString("type_doc");
			    id_etape = resultat.getInt("id_etape");
			    mot_cle = resultat.getString("mot_cle");
			    diposer = resultat.getString("diposer");
			    list.add(new document(id_doc,id_etape,type_doc,nom_doc,mot_cle,diposer));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}

	public document getdocument(Integer i){
		document d;
		ResultSet resultat = null;
		try {
			resultat = this.con.createStatement().executeQuery("SELECT * FROM document where "
					+ "id_doc = " + "'i'");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		Integer id_doc =null;
	    String nom_doc="";
	    String type_doc="";
	    Integer id_etape =null;
	    String mot_cle="";
	    String diposer="";
		boolean isEmpty=false;
		try {
			while(resultat.next())
			{
			    isEmpty=true;
			    id_doc = resultat.getInt("id_doc");
			    nom_doc = resultat.getString("nom_doc");
			    type_doc = resultat.getString("type_doc");
			    id_etape = resultat.getInt("id_etape");
			    mot_cle = resultat.getString("mot_cle");
			    diposer = resultat.getString("diposer");
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		if(isEmpty){
			d= new document( id_doc,id_etape,type_doc,nom_doc,mot_cle,diposer);
			return d;
		}
		else return null;
	}
	public boolean delete(document d){
		try { 
			
			     PreparedStatement st;
				    st = (PreparedStatement) con.prepareStatement("delete from document where id_doc = ?");
				    st.setInt(1, d.getId_doc());
				    st.execute();
				    return true;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
	  }
	 }
	}



