package Metier;

public class entreprise {
     private Integer id_Es;
     private String email_ES , tele_ES, responsable_Es;
	public entreprise(Integer id_Es, String email_ES, String tele_ES, String responsable_Es) {
		super();
		this.id_Es = id_Es;
		this.email_ES = email_ES;
		this.tele_ES = tele_ES;
		this.responsable_Es = responsable_Es;
	}
	public Integer getId_Es() {
		return id_Es;
	}
	public void setId_Es(Integer id_Es) {
		this.id_Es = id_Es;
	}
	public String getEmail_ES() {
		return email_ES;
	}
	public void setEmail_ES(String email_ES) {
		this.email_ES = email_ES;
	}
	public String getTele_ES() {
		return tele_ES;
	}
	public void setTele_ES(String tele_ES) {
		this.tele_ES = tele_ES;
	}
	public String getResponsable_Es() {
		return responsable_Es;
	}
	public void setResponsable_Es(String responsable_Es) {
		this.responsable_Es = responsable_Es;
	}
     
	public Object get(int i){
		switch (i){
		case 3 : return this.getResponsable_Es();
		case 2 : return this.getTele_ES();
		case 1 : return this.getEmail_ES();
		case 0 : return this.getId_Es();
		}
		return null;
	}

	public static String[] getAttributs(){
		String[] resultat = {"id_Es","email_ES","tele_ES","responsable_Es"};
		return resultat;
		} 
     
     
     
}
