package Metier ;
public class rendez{
	private Integer id_rv;
	private Integer id_prof;
	private Integer id;
	private String date;
	private String heur;
	
	public Integer getId_rv() {
		return id_rv;
	}
	public void setId_rv(Integer id_rv) {
		this.id_rv = id_rv;
	}
	public String getHeur() {
		return heur;
	}
	public void setHeur(String heur) {
		this.heur = heur;
	}
	public int getId_prof() {
		return id_prof;
	}
	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public rendez(Integer id_prof, Integer id, String date, String heur) {
		super();
		this.id_prof = id_prof;
		this.id = id;
		this.date = date;
		this.heur = heur;
	}
	public rendez(Integer id_rv,Integer id_prof,Integer id, String date, String heur) {
		super();
		this.id_rv=id_rv;
		this.id_prof = id_prof;
		this.id = id;
		this.date = date;
		this.heur = heur;
	}
	public Object get(int i){
		switch (i){
		
		case 2 : return this.getId();
		case 3 : return this.getDate();
		case 4: return this.getHeur();
		case 1 : return this.getId_prof();
		case 0 : return this.getId_rv();
		}
		return null;
	}

	public static String[] getAttributs(){
		String[] resultat = {"id_rv","id_prof","id","date","heure"};
		return resultat;
		} 
       
}
