package Metier;

public class laboratoire {
  private Integer id_labo;
  private String nom_labo;
  private String email_labo;
public laboratoire(Integer id_labo, String nom_labo, String email_labo) {
	super();
	this.id_labo = id_labo;
	this.nom_labo = nom_labo;
	this.email_labo = email_labo;
}
public Integer getId_labo() {
	return id_labo;
}
public void setId_labo(Integer id_labo) {
	this.id_labo = id_labo;
}
public String getNom_labo() {
	return nom_labo;
}
public void setNom_labo(String nom_labo) {
	this.nom_labo = nom_labo;
}
public String getEmail_labo() {
	return email_labo;
}
public void setEmail_labo(String email_labo) {
	this.email_labo = email_labo;
}
public Object get(int i){
	switch (i){
	case 2 : return this.getEmail_labo();
	case 1 : return this.getNom_labo();
	case 0 : return this.getId_labo();
	}
	return null;
}

public static String[] getAttributs(){
	String[] resultat = {"id_labo","nom_labo","email_labo"};
	return resultat;
	}
  
}
