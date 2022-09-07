package Metier;

public class etudiant {
     private Integer id;
     private String name , prenom , 
     email , nom_filiere , niveau , password;
     
	public etudiant() {
		super();
	}

	public etudiant( String name, String prenom, String email, String nom_filiere, String niveau , String password) {
		super();
		
		this.name = name;
		this.prenom = prenom;
		this.email = email;
		this.nom_filiere = nom_filiere;
		this.niveau = niveau;
		this.password=password;
	}
     
	
	

	public etudiant(Integer id, String name, String prenom, String email, String nom_filiere, String niveau,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.prenom = prenom;
		this.email = email;
		this.nom_filiere = nom_filiere;
		this.niveau = niveau;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFiliere() {
		return nom_filiere;
	}

	public void setFiliere(String filiere) {
		this.nom_filiere = filiere;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	public Object get(int i){
		switch (i){
		case 1 : return this.getName();
		case 2 : return this.getPrenom();
		case 3 : return this.getEmail();
		case 4 : return this.getFiliere();
		case 5 : return this.getNiveau();
		case 6 : return this.getPassword();
		case 0 : return this.getId();
		}
		return null;
	}

	public static String[] getAttributs(){
		String[] resultat = {"id","name","prenom","email","nom_filiere","niveau","password"};
		return resultat;
		}
     
}
