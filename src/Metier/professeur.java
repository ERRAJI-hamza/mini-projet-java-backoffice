package Metier;

public class professeur {
	private Integer id_prof;
	private String nom_prof;
	private String prenom_prof;
	private String grade;
	private String email_prof;
	private Integer id_labo;
	private String nom_filiere;
	private String nom_departement;
	private String password;
	private String role;
	public professeur(String nom_prof,String prenom_prof,String grade,String email_prof,
			Integer id_labo,String nom_filiere,String nom_departement,String password,String role){
		
		this.nom_prof=nom_prof;
		this.prenom_prof=prenom_prof;
		this.grade=grade;
		this.email_prof=email_prof;
		this.id_labo=id_labo;
		this.nom_filiere=nom_filiere;
		this.nom_departement=nom_departement;
		this.password=password;
		this.role=role;
}
	
	public professeur(Integer id_prof, String nom_prof, String prenom_prof, String grade, String email_prof, Integer id_labo,
			String nom_filiere, String nom_departement, String password,String role) {
		super();
		this.id_prof = id_prof;
		this.nom_prof = nom_prof;
		this.prenom_prof = prenom_prof;
		this.grade = grade;
		this.email_prof = email_prof;
		this.id_labo = id_labo;
		this.nom_filiere = nom_filiere;
		this.nom_departement = nom_departement;
		this.password = password;
		this.role=role;
	}
    
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail_prof() {
		return email_prof;
	}
	public Integer getId_prof() {
		return id_prof;
	}
	public String getNom_prof() {
		return nom_prof;
	}
	public String getPrenom_prof() {
		return prenom_prof;
	}
	public String getGrade() {
		return grade;
	}
	public Integer getId_labo() {
		return id_labo;
	}
	public String getNom_departement() {
		return nom_departement;
	}
	public String getNom_filiere() {
		return nom_filiere;
	}
	public String getPassword() {
		return password;
	}
	
	public void setEmail_prof(String email_prof) {
		this.email_prof = email_prof;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setId_prof(Integer id_prof) {
		this.id_prof = id_prof;
	}
	public void setNom_prof(String nom_prof) {
		this.nom_prof = nom_prof;
	}
	public void setPrenom_prof(String prenom_prof) {
		this.prenom_prof = prenom_prof;
	}
	public void setId_labo(Integer id_labo) {
		this.id_labo = id_labo;
	}
	public void setNom_departement(String nom_departement) {
		this.nom_departement = nom_departement;
	}
	public void setNom_filiere(String nom_filiere) {
		this.nom_filiere = nom_filiere;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Object get(int i){
		switch (i){
		case 1 : return this.getNom_prof();
		case 2 : return this.getPrenom_prof();
		case 4 : return this.getEmail_prof();
		case 6 : return this.getNom_filiere();
		case 5 : return this.getNom_departement();
		case 8 : return this.getPassword();
		case 0 : return this.getId_prof();
		case 3 : return this.getGrade();
		case 7 : return this.getId_labo();
		case 9 : return this.getRole();
		}
		return null;
	}

	public static String[] getAttributs(){
		String[] resultat = {"id_prof","nom_prof","prenom_prof","grad","email_prof","nom_departement","nom_filiere","id_labo","password","role"};
		return resultat;
		}
	

}