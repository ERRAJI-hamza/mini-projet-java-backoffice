package Presentation;

import java.awt.*;
import java.awt.event.* ;
import java.util.ArrayList;

import javax.swing.*;

import Metier.etudiant;
import Metier.professeur;
import Metier.Gestionnaire.Gestionnaireprojet;
import Metier.Gestionnaire.Gestionnairetudiante;
import Persistance.Daoprofesseur;
import Persistance.*;

import java.awt.event.* ;
class avoirendez extends JFrame {
	private JLabel date;
	private JLabel heure;
	private TextField xdate;
	private TextField xheure;
	private JLabel etudiant;
	
	private JComboBox jc1;
	private JButton inscre;
    private String s1;
    private Controleur controleur;
    private Integer n=0;
	
	public avoirendez(Controleur controleur,Integer a) throws ClassNotFoundException {
	    n=a;
		this.setTitle("votre rendez-vous");
		this.setSize(500, 500);
		this.initialiser(controleur);
		this.dessinner();
		this.executer();
	}
	private void initialiser( Controleur controleur) throws ClassNotFoundException {
    inscre =new JButton("inscre");
    date= new JLabel("date: ");
    heure = new JLabel("heure: ");
	etudiant= new JLabel("etudiant");
    xdate=new TextField(30);
    xheure=new TextField(30);
    
    jc1 =new JComboBox();
	Gestionnaireprojet dao = new Gestionnaireprojet();
	ArrayList<Integer> l = dao.getidEtud(n);
	for(Integer e : l){
		    jc1.addItem(e.toString());
		    }
		//    }
	this.controleur=controleur;
}
	private void dessinner() {
		this.setLayout(new BorderLayout());
		JPanel p= new JPanel();
		Container c1 =new Container();
		Container c2 =new Container();
		Container c3 =new Container();
		Container c4=new Container();
		Container c5=new Container();
		
	    GridLayout g =new GridLayout(5,3);
	    g.setVgap(20);
	    p.setLayout(g);
		p.add(date);
		p.add(c1);
		p.add(xdate);
		p.add(heure);
		p.add(c2);
		p.add(xheure);
		p.add(etudiant);
		p.add(c3);
		p.add(jc1);
		p.add(new Container());
		p.add(new Container());
		p.add(new Container());
		p.add(new Container());
		p.add(new Container());
		p.add(new Container());
		JPanel p1= new JPanel();
		p1.setLayout(new GridLayout(1,1));
		p1.add(inscre);
		this.add(p1,BorderLayout.SOUTH);
		this.add(p, BorderLayout.CENTER);
}
private void colsing() {
	this.dispose();
}
private void executer() {

    inscre.addActionListener(new ActionListener() {
			@Override
        public void actionPerformed(ActionEvent e) {
				try {
				       s1=jc1.getSelectedItem().toString();      
				 	  
					controleur.ajouter_rendez(n,Integer.parseInt(s1),xdate.getText(),xheure.getText());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				colsing();
			}
		});
}}

	
	
	
