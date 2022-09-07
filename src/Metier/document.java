package Metier;

public class document {
	
	    private Integer id_doc,id_etape;
        private String nom_doc,type_doc,mot_cle,diposer;
        
        
        
		public document(Integer id_etape, String nom_doc, String type_doc ,String mot_cle,String diposer) {
			super();
			this.id_etape = id_etape;
			this.nom_doc = nom_doc;
			this.type_doc = type_doc;
			this.mot_cle=mot_cle;
			this.diposer=diposer;
		}

		public document(Integer id_doc, Integer id_etape, String nom_doc, String type_doc,String mot_cle,String diposer) {
			super();
			this.id_doc = id_doc;
			this.id_etape = id_etape;
			this.nom_doc = nom_doc;
			this.type_doc = type_doc;
			this.mot_cle=mot_cle;
			this.diposer=diposer;
		}
        
		public String getMot_cle() {
			return mot_cle;
		}

		public void setMot_cle(String mot_cle) {
			this.mot_cle = mot_cle;
		}

		public String getDiposer() {
			return diposer;
		}

		public void setDiposer(String diposer) {
			this.diposer = diposer;
		}

		public Integer getId_doc() {
			return id_doc;
		}

		public void setId_doc(Integer id_doc) {
			this.id_doc = id_doc;
		}

		public Integer getId_etape() {
			return id_etape;
		}

		public void setId_etape(Integer id_etape) {
			this.id_etape = id_etape;
		}

		public String getNom_doc() {
			return nom_doc;
		}

		public void setNom_doc(String nom_doc) {
			this.nom_doc = nom_doc;
		}

		public String getType_doc() {
			return type_doc;
		}

		public void setType_doc(String type_doc) {
			this.type_doc = type_doc;
		}

		public Object get(int i){
			switch (i){
			case 5 : return this.getDiposer();
			case 4 : return this.getMot_cle();
			case 3 : return this.getId_etape();
			case 2 : return this.getType_doc();
			case 1 : return this.getNom_doc();
			case 0 : return this.getId_doc();
			}
			return null;
		}

		public static String[] getAttributs(){
			String[] resultat = {"id_doc","nom_doc","type_doc","id_etape","mot_cle","diposer"};
			return resultat;
			}
		  
		}

