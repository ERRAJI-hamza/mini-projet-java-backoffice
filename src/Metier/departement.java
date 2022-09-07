package Metier;

public class departement {
            private String nom_departement;
            private String email_departement;
			public departement(String nom_departement, String email_departement) {
				super();
				this.nom_departement = nom_departement;
				this.email_departement = email_departement;
			}
			public String getNom_departement() {
				return nom_departement;
			}
			public void setNom_departement(String nom_departement) {
				this.nom_departement = nom_departement;
			}
			public String getEmail_departement() {
				return email_departement;
			}
			public void setEmail_departement(String email_departement) {
				this.email_departement = email_departement;
			}
			public Object get(int i){
				switch (i){
				case 1 : return this.getEmail_departement();
				case 0 : return this.getNom_departement();
				}
				return null;
			}

			public static String[] getAttributs(){
				String[] resultat = {"nom_departement","email_departement"};
				return resultat;
				}
            
}
