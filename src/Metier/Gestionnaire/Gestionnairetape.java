package Metier.Gestionnaire;

import java.util.ArrayList;

import Metier.*;
import Persistance.*;


public class Gestionnairetape {
	private Daoetape daoet;
    private Integer ide;
    private Daoprojet daoprj;
	public ArrayList<etape> getlistetape(Integer idprojet) throws ClassNotFoundException{
		
		  daoprj=new Daoprojet();
		  daoet=new Daoetape();
          ArrayList<etape> l= daoet.getAll();
          ArrayList<etape>list=new ArrayList<>();
             for (etape et: l) {
		     	    if(et.getId_projet()==idprojet){
			    	list.add(et);
			    }
		      }
		     return list;
             }
   }
