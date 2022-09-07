package Metier.Gestionnaire;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Metier.*;

import Persistance.*;

public class Gestionnairetudiante {
       private Daoetudiant dao;
       private Integer ide;
       private Daoprojet daoprj;
   	public ArrayList<Integer> getnewetudient() throws ClassNotFoundException{
   		boolean b=true;
   		daoprj=new Daoprojet();
   		dao=new Daoetudiant();
           ArrayList<projet> L= daoprj.getAll();
           ArrayList<etudiant> Le= dao.getAll();
           ArrayList<Integer> letu= new ArrayList<>();
           for(int i=0 ;i<Le.size() ;i++){
        	   ide=Le.get(i).getId();
        	   for (int j = 0; j < L.size(); j++) {
				   if(ide==L.get(j).getId()){
					     b=false;
					     break;
				   }
			   }
        	 if(b){
					letu.add(Le.get(i).getId());
			 }
           }
           return letu;
       }
	
public void ajouterprjer(etudiant p) throws ClassNotFoundException{
		
    	dao.setetudiant(p);
    }
public void modifierprojet(etudiant p) throws ClassNotFoundException{
		
		dao.setetudiant(p);
    }
public void deleteprojet(etudiant p) throws ClassNotFoundException{
		
	     dao.delete(p);
    } 
	
}
