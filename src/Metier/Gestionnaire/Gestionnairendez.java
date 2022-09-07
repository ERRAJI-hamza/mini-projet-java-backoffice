package Metier.Gestionnaire;

import java.util.ArrayList;

import Metier.*;
import Persistance.*;
import Persistance.Daoetape;
import Persistance.Daorendez;

public class Gestionnairendez{
	private Daorendez dao;
    private Integer ide;
	public ArrayList<rendez> getlistrendezprof(Integer id_prof) throws ClassNotFoundException{
		  dao=new Daorendez();
          ArrayList<rendez> l= dao.getAll();
          ArrayList<rendez> list= new ArrayList();
             for (rendez r : l) {
		     	    if(r.getId_prof()==id_prof){
			    	  list.add(r);
			    }
		      }
		     return list;
             }
	public ArrayList<rendez> getlistrendezetud(Integer id) throws ClassNotFoundException{
		dao=new Daorendez();
        ArrayList<rendez> l= dao.getAll();
        ArrayList<rendez> list= new ArrayList();
           for (rendez r : l) {
		     	    if(r.getId()==id){
			    	  list.add(r);
			    }
		      }
		     return list;
           }
}
