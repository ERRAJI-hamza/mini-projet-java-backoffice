package Presentation;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
import javax.swing.JOptionPane;
import Metier.*;
import Metier.Gestionnaire.*;
import Persistance.*;
import Presentation.*;
public class Controleur {
	private Integer id=null , id_prof=null , id_labo=-1, id_Es=-1, encadrant_2=-1, z,w;
    private String titre  , type , date_debut, duree;
	public Controleur() {
		super();
	}
	
	public void demmarrer() {
		login p = new login(this);
		p.show();
	}
	//dans argument du fct faut utiliser e pou reagir avec getx par exemple
	public void validerProfil(String name, String prenom, String email, String nom_filiere, String niveau , String password,String CONfirmedPassword)throws ClassNotFoundException {
		if(password.equals(CONfirmedPassword)) {
		etudiant u = new etudiant( name,  prenom,  email,  nom_filiere,  niveau ,  password );
		 Daoetudiant dao = new Daoetudiant();
		 dao.setetudiant(u);
		 fenetretudiant p = new fenetretudiant(this,dao.getAll());
		  p.show();
		}
		else {
			demmarrer();
			JOptionPane.showMessageDialog(null, "Dommage :(Configuration mot pass incorrect") ;
			
		}
	}
	public void validerFormulaire(String nom_prof,String prenom_prof,String grade,String email_prof,
			int id_labo,String nom_filiere,String nom_departement,String password ,String role ,String CONfirmedPassword) throws ClassNotFoundException {
		if(password.equals(CONfirmedPassword)){
		professeur u = new professeur( nom_prof, prenom_prof, grade,  email_prof , id_labo ,
				nom_filiere , nom_departement , password,role);
		Daoprofesseur dao = new Daoprofesseur();
		dao.setprofesseur(u);
		fenetreProfesseur p=new fenetreProfesseur(this, dao.getAll());
		p.show();
		}
		else {
			demmarrer();
			JOptionPane.showMessageDialog(null, "Dommage :(Configuration mot pass incorrect") ;
		}
	}
	public void EtudToProf() {
		
		FormulairePrf p = new FormulairePrf(this);
	p.show();
	}
	public void ProfToEtud(){
		Formulaire p = new Formulaire(this);
	    p.show();
	}
	public void SinscrireProfil(Integer id , String password) throws ClassNotFoundException {
		Daoetudiant dao = new Daoetudiant();
		ArrayList<etudiant> l = dao.getAll();
		Daoprofesseur daop = new Daoprofesseur();
		ArrayList<professeur> lp = daop.getAll();
		int b=0;
		
		for(etudiant e : l){
		    if(e.getId()==id && (e.getPassword().compareTo(password)==0)) {
		    	b=1;
		    	w=e.getId();break;}
				   
		    }
		  for(professeur pr : lp){
			    if(pr.getId_prof()==id && (pr.getPassword().compareTo(password)==0)){
			    	z=pr.getId_prof();b=2;break;}
					   
			    }
		if(id==100 && (password.compareTo("admin"))==0){
			   gestion p = new gestion(this);
			   p.show();
		}
		else if(b==1) {
			    	FormuleEtud fe=new	FormuleEtud(this,w);
			    	 fe.show();
			    	  }
		      
		else if(b==2) {
		        	frontprof fe=new frontprof(this,z);
			    	 fe.show();
			    	 
			    }
		      
		else {
			JOptionPane.showMessageDialog(null, "Dommage :(Configuration mot pass incorrect") ;
			    	login p = new login(this);
				      p.show();
				      
			    }
		      }
		      
		

	public void identifier(){
		login p = new login(this);
	      p.show();
	}
	
	public void afficheElemProf(){
		
	}
	public void superimeretudiant(etudiant etu) throws ClassNotFoundException{
		 Daoetudiant dao = new Daoetudiant();
	     dao.delete(etu);
	     fenetretudiant mf = new fenetretudiant(this , dao.getAll());
		 mf.show();
}
	public void superimerprof(professeur pr) throws ClassNotFoundException{
		 Daoprofesseur daop =new Daoprofesseur();
		 Gestionnaireprof dao =new Gestionnaireprof();
	     dao.deleteprof(pr);
	     fenetreProfesseur mf = new fenetreProfesseur(this , daop.getAll());
		 mf.show();
}
	public void gestionprof() throws ClassNotFoundException{
		Daoprofesseur d = new Daoprofesseur();
		fenetreProfesseur p=new fenetreProfesseur(this,d.getAll());
	      p.show();
	}
	public void gestionetud() throws ClassNotFoundException{
		Daoetudiant d = new Daoetudiant();
		fenetretudiant p=new fenetretudiant(this,d.getAll());
	      p.show();
	}
	public void validerfiliere(String nf, String nfd)throws ClassNotFoundException {
		 Daofiliere dao = new Daofiliere();
		 filiere fi =new filiere(nf, nfd);
		 dao.setfiliere(fi);
		gestion p = new gestion(this);
		p.show();
		}
	public void validerdepartement(String nd, String ed , int i)throws ClassNotFoundException {
		 Daodepartement dao = new Daodepartement();
		 departement dp = new departement(nd, ed);
		 dao.setdepartement(dp,i);
		gestion p = new gestion(this);
		p.show();
		}
	public void validerlabo(Integer idl,String nl, String el)throws ClassNotFoundException {
		 Daolabo dao = new Daolabo();
		 laboratoire l=new laboratoire(idl ,nl, el);
		 dao.setlabo(l);
		 fenetrelabo f=new fenetrelabo(this, dao.getAll());
		 f.show();
		}
    public void formsf(){
		formulairefiliere p = new formulairefiliere(this);
	    p.show();
	}
    public void formsd(){
		formlabo p = new formlabo(this);
	    p.show();
	}
    public void formsde(){
		formulairedepartement p = new formulairedepartement(this);
	    p.show();
	}
    public void superimerfiliere(filiere fi) throws ClassNotFoundException{
		 Daofiliere dao = new Daofiliere();
	     dao.delete(fi);
	     fenetrefiliere mf = new fenetrefiliere(this , dao.getAll());
		 mf.show();
      } 
    public void superimerdepartement(departement dp) throws ClassNotFoundException{
		 Daodepartement dao = new Daodepartement();
	     dao.delete(dp);
	     fenetredepartement mf = new fenetredepartement(this , dao.getAll());
		 mf.show();
     }
    public void superimerlabo(laboratoire l) throws ClassNotFoundException{
		 Daolabo dao = new Daolabo();
	     dao.delete(l);
	     fenetrelabo mf = new fenetrelabo(this , dao.getAll());
		 mf.show();
    }
    public void gestionfiliere() throws ClassNotFoundException{
		Daofiliere d = new Daofiliere();
		fenetrefiliere p=new fenetrefiliere(this,d.getAll());
	      p.show();
	}
    
    public void gestiondepartement() throws ClassNotFoundException{
		Daodepartement d= new Daodepartement();
		fenetredepartement p=new fenetredepartement(this,d.getAll());
	      p.show();
	}
    public void gestionlabo() throws ClassNotFoundException{
		Daolabo d= new Daolabo();
		fenetrelabo p=new fenetrelabo(this,d.getAll());
	      p.show();
	}
    public void gestionprojet() throws ClassNotFoundException{
		Daoprojet d= new Daoprojet();
		fenetreprojet p=new fenetreprojet(this,d.getAll());
	      p.show();
	}
    public void affiprj() {
    	formulaireprojet f=new formulaireprojet(this);
    	f.show();
    }
    public void pfe(String s1 , String s2) {
    	titre=s1;type=s2;
    	formulairePfe f =new formulairePfe(this);
    	f.show();
    }
    public void fnprj(String s1 , String s2 , Integer i ,int k ) throws ClassNotFoundException {
    	date_debut=s1;duree=s2;
    	if(k==1) {id_labo=i;} else if(k==2) {id_Es=i;}
    	fenetreaffectation f =new fenetreaffectation(this);
    	f.show();
    }
    public void fnprjdr(String s1 , String s2 , Integer i ,int k ) throws ClassNotFoundException {
    	date_debut=s1;duree=s2;
    	if(k==1) {id_labo=i;} else if(k==2) {id_Es=i;}
    	fenetreaffectionDr f =new fenetreaffectionDr(this);
    	f.show();
    }

	public void inprjet(String s1, String s2) throws ClassNotFoundException {
		id=Integer.parseInt(s1);id_prof=Integer.parseInt(s2);
		projet pr = new projet (titre, date_debut, duree, type, id, id_prof, id_labo, id_Es,encadrant_2);
    	Daoprojet dao =new Daoprojet();
        dao.setprojet(pr);
    	fenetreprojet f = new fenetreprojet(this,dao.getAll());
    	f.show();
	}

	public void pfa(String s1, String s2) {
		titre=s1;type=s2;
    	formulairePfa f =new formulairePfa(this);
    	f.show();
		
	}

	public void dr(String s1, String s2) {
		titre=s1;type=s2;
    	formulaireDr f =new formulaireDr(this);
    	f.show();
	}

	public void inprjetdr(String s1, String s2, String s3) throws ClassNotFoundException {
		id=Integer.parseInt(s1);id_prof=Integer.parseInt(s2);encadrant_2=Integer.parseInt(s3);
		projet pr = new projet (titre, date_debut, duree, type, id, id_prof, id_labo, id_Es,encadrant_2);
    	Daoprojet dao =new Daoprojet();
        dao.setprojet(pr);
    	fenetreprojet f = new fenetreprojet(this,dao.getAll());
    	f.show();
		
	}

	public void fntped(Integer id_prof2) throws ClassNotFoundException {
		Gestionnaireprojet G=new Gestionnaireprojet();
		ArrayList<Integer> l=G.getidprojet(id_prof2);
		fenetrelistprojetduprof f =new fenetrelistprojetduprof(this, l);
		f.show();
	}

	public  void fntetape(Integer idprj ) throws ClassNotFoundException {
		   Gestionnairetape G=new Gestionnairetape();
		   ArrayList<etape> l =G.getlistetape(idprj);
		   frontped f =new frontped(this, l,idprj);
		   f.show();
	}

	public void valideretape(Integer id_etape, String duree, String etape_de_depart, Integer id_projet) throws ClassNotFoundException {
		 Daoetape dao= new Daoetape();
		 etape etp =new etape(id_etape, id_projet,etape_de_depart,duree);
		 dao.setetape(etp);
		 fntetape(id_projet);
	}

	public void frmsetape(Integer id_projet) {
		formrmulairetape f  =new formrmulairetape(this, id_projet);
		f.show();
		
	}

	public void diposerdoc(Integer id_etape , Integer id_projet) {
		formsdoc f =new formsdoc(this, id_etape , id_projet);
		f.show();
	}

	public void diposerdocument(String text, String tselectedItem, Integer id_etape ,Integer id_projet,String mc,String diposerprof) throws ClassNotFoundException {
		Daodocument dao = new Daodocument();
		document d =new document(id_etape, text, tselectedItem,mc,diposerprof);
		dao.setdocument(d);
		fntetape(id_projet);
		
	}

	public void fntetd(Integer id2) throws ClassNotFoundException {
		Gestionnaireprojet G=new Gestionnaireprojet();
		Integer I=G.getprojet(id2);
		Gestionnairetape Ge=new Gestionnairetape();
		ArrayList<etape> l =Ge.getlistetape(I);
		frontpedetd f=new frontpedetd(this, l, I);
	}

	public void diposerdocetd(Integer id_etape, Integer id_projet) {
		formsdocetud f =new formsdocetud(this, id_etape , id_projet);
		f.show();
		
	}
	public void diposerdocumentbyetd(String text, String tselectedItem, Integer id_etape ,Integer id_projet,String mc,String diposerprof) throws ClassNotFoundException {
		Daodocument dao = new Daodocument();
		document d =new document(id_etape, text, tselectedItem,mc,diposerprof);
		dao.setdocument(d);
		fntetd(id_projet);
		
	}

	public void opendoc(Integer id_etape) throws ClassNotFoundException {
		   Gestionnairedocument G=new Gestionnairedocument();
		   ArrayList<document> l =G.getlistdocument(id_etape);
		   fenetredocument f =new fenetredocument(this, l,id_etape);
		   f.show();
		
	}

	public void ouvrirdoc(String s) throws IOException {
		Gestionnairedocument G =new Gestionnairedocument();
		    G.openfile(s);
	}

	public  void getdoc(String text,Integer id_etape) throws ClassNotFoundException {
		Gestionnairedocument G=new Gestionnairedocument();
		   ArrayList<document> l =G.getdocuParmotcle(text,id_etape);
		   fenetredocument f =new fenetredocument(this, l,id_etape);
		   f.show();
		
		
	}


	public void formodifier(projet prj) throws ClassNotFoundException {
		modifierprojet f=new modifierprojet(prj,this);
		f.show();
		
	}

	public void inscrprojet(Integer id_projet, String text, String text2, String s, String ss, Integer parseInt,
		Integer parseInt2, Integer k, Integer parseInt3, Integer j) throws ClassNotFoundException {
		Daoprojet dap =new Daoprojet();
		projet p= new projet(id_projet, text, text2, s, ss, parseInt, parseInt2, k, parseInt3, j);
		dap.setprojet(p);
		fenetreprojet f=new fenetreprojet(this, dap.getAll());
		f.show();
		
	}

	public void modifiereEtd(etudiant etu) {
		Formulaire f=new Formulaire(etu, this);
		f.show();
		
	}

	public void modifEtd(Integer id2, String text, String text2, String text3, String text4, String text5, String text6,
			String text7) throws ClassNotFoundException {
		if(text6.equals(text7)) {
			etudiant u = new etudiant( id2,text, text2,  text3,  text4,  text5,  text6);
			 Daoetudiant dao = new Daoetudiant();
			 dao.setetudiant(u);
			 fenetretudiant p = new fenetretudiant(this,dao.getAll());
			  p.show();
			}
			else {
				demmarrer();
				JOptionPane.showMessageDialog(null, "Dommage :(Configuration mot pass incorrect") ;
				
			}
		
	}

	public void modifierprof(professeur pr) {
		FormulairePrf mf = new FormulairePrf(pr , this);
		 mf.show();
		
	}

	public void modifpr(Integer id_prof2, String text, String text2, String text3, String text4, Integer parseInt,
			String text5, String text6, String text7, String s1, String text8) throws ClassNotFoundException {
		if(text7.equals(text8)){
			professeur u = new professeur( id_prof2, text,text2,  text3 , text4,
					parseInt , text5 , text6,text7,s1);
			Daoprofesseur dao = new Daoprofesseur();
			dao.setprofesseur(u);
			fenetreProfesseur p=new fenetreProfesseur(this,dao.getAll());
			p.show();
			}
			else {
				demmarrer();
				JOptionPane.showMessageDialog(null, "Dommage :(Configuration mot pass incorrect") ;
			}
		
	}

	
		public void validerentreprise(int i, String text2, String text3, String text4, int type) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			DaoEs dao = new DaoEs();
		     System.out.print("fds");
		     entreprise fi =new entreprise(i, text2,text3,text4);
			 dao.setentreprise(fi, type); 
			gestion p = new gestion(this);
			p.show();
			
		}

		public void modifierentreprise(entreprise dp) {
			// TODO Auto-generated method stub
			formEntrprs p = new formEntrprs(dp,this,1);
		    p.show();
		}

		public void superimerentreprise(entreprise dp) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			DaoEs dao = new DaoEs();  
		     dao.delete(dp);
		     fenetreEntreprise mf = new fenetreEntreprise(this , dao.getAll());
			 mf.show();
		}

		public void formEnt() {
			formEntrprs p = new formEntrprs(this);
		    p.show();
		}

		public void gestionentreprise() throws ClassNotFoundException {
			DaoEs d = new DaoEs();
			fenetreEntreprise p=new fenetreEntreprise(this,d.getAll());
		      p.show();
		}

		public void modifierlabo(laboratoire l) {
			formlabo a =new formlabo(l,this);
			a.show();
			
		}

		public void modifierlabo(Integer id2, Integer parseInt, String text, String text2) throws ClassNotFoundException {
			         if(id2!=parseInt){
			        	 JOptionPane.showMessageDialog(null, "Dommage :(Configuration impossible de modifier id") ;
			         }
			         else{
			        	 Daolabo dao = new Daolabo();
			    		 laboratoire l=new laboratoire(id2 ,text, text2);
			    		 dao.updatelabo(l);
			    		 fenetrelabo f=new fenetrelabo(this, dao.getAll());
			    		 f.show();
			         }
		}

		public void modifierdepartement(departement dp) {
			formulairedepartement fd = new formulairedepartement(dp,this,1);
			fd.show();
		}

		public void fntrendezprof(Integer id_prof2) throws ClassNotFoundException {
			   Gestionnairendez G=new Gestionnairendez();
			   ArrayList<rendez> l =G.getlistrendezprof(id_prof2);
			   fenetrendez f=new fenetrendez(this, l,id_prof2);
			   f.show();
			
		}

		public void fntrendezetd(Integer id) throws ClassNotFoundException {
			   Gestionnairendez G=new Gestionnairendez();
			   ArrayList<rendez> l =G.getlistrendezetud(id);
			   fenetrendez f=new fenetrendez(this, l);
			   f.show();	
		}

		public void formsrv(Integer n) throws ClassNotFoundException {
			avoirendez f =new avoirendez(this, n);
			f.show();
			
		}

		public void ajouter_rendez(Integer n, Integer parseInt, String s1, String s2) throws ClassNotFoundException {
				Daorendez dao = new Daorendez();
				Gestionnairendez G=new Gestionnairendez();
			    rendez fi =new rendez(n, parseInt,s1,s2);
				dao.setrendez(fi); 
				ArrayList<rendez> l =G.getlistrendezprof(n);
				fenetrendez f=new fenetrendez(this, l,n);
				f.show();
			}
			
		}
	
	
