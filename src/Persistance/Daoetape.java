package Persistance;
	import Metier.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import com.mysql.jdbc.PreparedStatement;

public class Daoetape {
	
	Connection con;
	public Daoetape() throws ClassNotFoundException {
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
	public void setetape(etape etp){
			  try{
				  
				PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into etape ( id_etape , duree , etape_de_depart,id_projet)"
				        	+ "values (? , ? ,?,?)");
						  st.setInt(1, etp.getId_etape());st.setString(2, etp.getDuree());st.setString(3, etp.getEtape_de_depart());
						  st.setInt(4, etp.getId_projet());st.execute();
				  
				  System.out.println("etape is save");
	              }
			  catch(SQLException ex){
				  ex.printStackTrace();
				  System.err.println("save erreur");
			    }
		}

		public ArrayList<etape> getAll() {
			ArrayList<etape> list = new ArrayList<etape>();
			ResultSet resultat = null;
			try {
				resultat = this.con.createStatement().executeQuery("SELECT * FROM etape");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Integer id_etape=null;
		    String duree="";
		    String etape_de_depart="";
		    Integer id_projet=null;
			try {
				while(resultat.next())
				{
					id_etape=resultat.getInt("id_etape");
				    duree = resultat.getString("duree");
				    etape_de_depart = resultat.getString("etape_de_depart");
				    id_projet=resultat.getInt("id_projet");
				    
				    list.add(new etape(id_etape , id_projet,etape_de_depart,duree));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
			}

		public etape getetpae(Integer i){
			etape etp;
			ResultSet resultat = null;
			try {
				resultat = this.con.createStatement().executeQuery("SELECT * FROM etape where "
						+ "id_etape= " + "'i'");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			Integer id_etape=null;
		    String duree="";
		    String etape_de_depart="";
		    Integer id_projet=null;
		   
			boolean isEmpty=false;
			try {
				while(resultat.next())
				{
				    isEmpty=true;
				    id_etape=resultat.getInt("id_etape");
				    duree = resultat.getString("duree");
				    etape_de_depart = resultat.getString("etape_de_depart");
				    id_projet=resultat.getInt("id_projet");
				   
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			if(isEmpty){
				etp = new etape(id_etape,id_projet,etape_de_depart,duree);
				return etp;
			}
			else return null;
		}
		public boolean delete(etape etp){
			try { 
				
				     PreparedStatement st;
					    st = (PreparedStatement) con.prepareStatement("delete from etape where id_etape = ?");
					    st.setInt(1, etp.getId_etape());
					    st.execute();
					    return true;
				} catch (SQLException ex) {
					ex.printStackTrace();
					return false;
		  }
		 }


		}


