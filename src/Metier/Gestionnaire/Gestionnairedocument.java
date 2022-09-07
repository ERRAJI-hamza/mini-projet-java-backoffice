package Metier.Gestionnaire;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Metier.document;
import Metier.etape;
import Persistance.Daodocument;
import Persistance.Daoetape;
import Persistance.Daoprojet;

public class Gestionnairedocument {
	private Daoetape daoetp;
    private Integer ide;
    private Daodocument daodoc;
	public ArrayList<document> getlistdocument(Integer idetape) throws ClassNotFoundException{
		  daodoc=new Daodocument();
		  daoetp=new Daoetape();
          ArrayList<document> l= daodoc.getAll();
          ArrayList<document>list=new ArrayList<>();
             for (document doc: l) {
		     	    if(doc.getId_etape()==idetape){
			    	list.add(doc);
			    }
		      }
		     return list;
             }
	public void openfile(String s) throws IOException {
		File file = new File(s);
    
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
        
	  }		
	public ArrayList<document> getdocuParmotcle(String s, Integer i) throws ClassNotFoundException{
		daodoc=new Daodocument();
		ArrayList<document> l= this.getlistdocument(i);
		ArrayList<document>list=new ArrayList<>();
		for (document doc: l) {
			String[] str = doc.getMot_cle().split(" ");
			 for(String sitem:str){
				 if(sitem.contains(s)){
					 list.add(doc);
					 break;
				 }
			 }
      }  
		
		return list;
	}
}

