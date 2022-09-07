package Metier;

public class etape {
	   private Integer id_etape,id_projet;
	   private String duree , etape_de_depart;
	   
	   
	public etape(Integer id_etape, Integer id_projet, String duree, String etape_de_depart) {
		super();
		this.id_etape = id_etape;
		this.id_projet = id_projet;
		this.duree = duree;
		this.etape_de_depart = etape_de_depart;
	}
    
	public Integer getId_etape() {
		return id_etape;
	}

	public void setId_etape(Integer id_etape) {
		this.id_etape = id_etape;
	}

	public Integer getId_projet() {
		return id_projet;
	}

	public void setId_projet(Integer id_projet) {
		this.id_projet = id_projet;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getEtape_de_depart() {
		return etape_de_depart;
	}

	public void setEtape_de_depart(String etape_de_depart) {
		this.etape_de_depart = etape_de_depart;
	}

	public Object get(int i){
		switch (i){
		case 3 : return this.getId_projet();
		case 2 : return this.getEtape_de_depart();
		case 1 : return this.getDuree();
		case 0 : return this.getId_etape();
		}
		return null;
	}

	public static String[] getAttributs(){
		String[] resultat = {"id_etape","duree","etape_de_depart","id_projet"};
		return resultat;
		}
	  
	}


