package Metier.Gestionnaire;
import Persistance.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Metier.*;
public class Gestionnaireprof {
     
	private Daoprojet daoprj;
	private Daoprofesseur dao;
	public void deleteprof(professeur p) throws ClassNotFoundException{
		daoprj=new Daoprojet();
		dao=new Daoprofesseur();
        ArrayList<projet> L= daoprj.getAll();
        for(int i=0 ;i<L.size() ;i++){
            if(p.getId_prof()==L.get(i).getId_prof())
            	JOptionPane.showMessageDialog(null, "Dommage :(prof encadre un projet") ;
                  break;
        }
        dao.delete(p);
    }
public void ajouterprof(professeur p) throws ClassNotFoundException{
		
        dao.setprofesseur(p);
    }
	public void modifierprof(professeur p) throws ClassNotFoundException{
		
        dao.setprofesseur(p);
    }
}
