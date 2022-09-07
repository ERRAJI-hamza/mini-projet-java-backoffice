package Metier;

public class projet {
       private Integer id_projet , id , id_prof , id_labo , id_Es,encadrant_2;
       private String titre  , type , date_debut, duree;
	public projet(String titre,String date_debut,String duree, String type,
			Integer id, Integer id_prof, Integer id_labo, Integer id_Es, Integer encadrant_2) {
		super();
		this.id = id;
		this.id_prof = id_prof;
		this.id_labo = id_labo;
		this.id_Es = id_Es;
		this.titre = titre;
		this.type = type;
		this.date_debut = date_debut;
		this.duree = duree;
		this.encadrant_2=encadrant_2;
	}
	public projet(Integer id_projet, String titre, String date_debut, String duree, String type,
			Integer id, Integer id_prof, Integer id_labo, Integer id_Es,Integer encadrant_2) {
		super();
		this.id_projet = id_projet;
		this.id = id;
		this.id_prof = id_prof;
		this.id_labo = id_labo;
		this.id_Es = id_Es;
		this.titre = titre;
		this.type = type;
		this.date_debut = date_debut;
		this.duree = duree;
		this.encadrant_2=encadrant_2;
	}
	
	public Integer getEncadrant_2() {
		return encadrant_2;
	}
	public void setEncadrant_2(Integer encadrant_2) {
		this.encadrant_2 = encadrant_2;
	}
	public Integer getId_projet() {
		return id_projet;
	}
	public void setId_projet(Integer id_projet) {
		this.id_projet = id_projet;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_prof() {
		return id_prof;
	}
	public void setId_prof(Integer id_prof) {
		this.id_prof = id_prof;
	}
	public Integer getId_labo() {
		return id_labo;
	}
	public void setId_labo(Integer id_labo) {
		this.id_labo = id_labo;
	}
	public Integer getId_Es() {
		return id_Es;
	}
	public void setId_Es(Integer id_Es) {
		this.id_Es = id_Es;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public Object get(int i){
		switch (i){
		case 9 : return this.getEncadrant_2();
		case 8 : return this.getId_Es();
		case 7 : return this.getId_labo();
		case 6:  return this.getId_prof();
		case 5 : return this.getId();
		case 2 : return this.getDate_debut();
		case 3 : return this.getDuree();
		case 4: return this.getType();
		case 1 : return this.getTitre();
		case 0 : return this.getId_projet();
		}
		return null;
	}

	public static String[] getAttributs(){
		String[] resultat = {"id_projet","titre","date_debut","duree","type","id","id_prof","id_labo","id_Es","encadrant_2"};
		return resultat;
		} 
       
       
}
