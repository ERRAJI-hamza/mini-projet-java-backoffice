package Metier;

public class filiere {
        private String nom_filiere;
        private String nom_departement;
		public filiere(String nom_filiere, String nom_departement) {
			super();
			this.nom_filiere = nom_filiere;
			this.nom_departement = nom_departement;
		}
		public String getNom_filiere() {
			return nom_filiere;
		}
		public void setNom_filiere(String nom_filiere) {
			this.nom_filiere = nom_filiere;
		}
		public String getNom_departement() {
			return nom_departement;
		}
		public void setNom_departement(String nom_departement) {
			this.nom_departement = nom_departement;
		}
        
		public Object get(int i){
			switch (i){
			case 1 : return this.getNom_departement();
			case 0 : return this.getNom_filiere();
			}
			return null;
		}

		public static String[] getAttributs(){
			String[] resultat = {"nom_filiere","nom_departement"};
			return resultat;
			}
        
}
