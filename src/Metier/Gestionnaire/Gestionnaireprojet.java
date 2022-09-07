package Metier.Gestionnaire;

import java.util.ArrayList;

import Metier.*;
import Persistance.*;


public class Gestionnaireprojet {
	private Daoprofesseur daopr;
	private Daoetudiant daoetd;
    private Integer ide;
    private Daoprojet daoprj;
	public ArrayList<Integer> getidprojet(Integer idprof) throws ClassNotFoundException{
		
		daoprj=new Daoprojet();
		daopr=new Daoprofesseur();
        ArrayList<projet> l= daoprj.getAll();
        ArrayList<Integer>list=new ArrayList<>();
          for (projet p: l) {
			    if(p.getId_prof()==idprof){
			    	list.add(p.getId_projet());
			    }
		}
		return list;
    }
   public Integer getprojet(Integer id) throws ClassNotFoundException{
		
		daoprj=new Daoprojet();
		daoetd=new Daoetudiant();
        ArrayList<projet> l= daoprj.getAll();
        Integer e ;
          for (projet p: l) {
			    if(p.getId()==id){
			    	ide=p.getId_projet();
			    	break;
			    }
		}
		return ide;
    }
   public ArrayList<Integer> getidEtud(Integer idprof) throws ClassNotFoundException{
		daoprj=new Daoprojet();
		daopr=new Daoprofesseur();
       ArrayList<projet> l= daoprj.getAll();
       ArrayList<Integer>list=new ArrayList<>();
         for (projet p: l) {
			    if(p.getId_prof()==idprof){
			    	list.add(p.getId());
			    }
		}
		return list;
		
	}

   public void ajouterprjer(projet p) throws ClassNotFoundException{
		
   	daoprj.setprojet(p);
   }
	public void modifierprojet(projet p) throws ClassNotFoundException{
		
		daoprj.setprojet(p);
   }
public void deleteprojet(projet p) throws ClassNotFoundException{
		
		daoprj.setprojet(p);
   }
}
