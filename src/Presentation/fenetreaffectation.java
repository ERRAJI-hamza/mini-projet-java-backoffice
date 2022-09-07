package Presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Metier.*;
import Persistance.*;
import Metier.Gestionnaire.*;

public class fenetreaffectation extends JFrame {
	
	private JLabel etudiant;
	private JLabel prof;
	private JComboBox jc1;
	private JComboBox jc2;
    private JButton inscre;
    private String s1,s2;
    private Controleur controleur;
	
	public fenetreaffectation(Controleur controleur) throws ClassNotFoundException {
		this.setTitle("Formulaire");
		this.setSize(500, 500);
		this.initialiser(controleur);
		this.dessinner();
		this.executer();
	}
	private void initialiser( Controleur controleur) throws ClassNotFoundException {
    inscre =new JButton("inscre");
	etudiant= new JLabel("etudiant: ");
	prof = new JLabel("encadrant: ");
	jc1 =new JComboBox();
	jc2 =new JComboBox();
	Gestionnairetudiante dao = new Gestionnairetudiante();
	ArrayList<Integer> l = dao.getnewetudient();
	
	for(Integer e : l){
		    jc1.addItem(e.toString());
		    }
	Daoprofesseur daop = new Daoprofesseur();
	ArrayList<professeur> l1 = daop.getAll();
	for(professeur p : l1){
		jc2.addItem(p.getId_prof().toString());
		    }
	this.controleur=controleur;
}
	private void dessinner() {
		this.setLayout(new BorderLayout());
		JPanel p= new JPanel();
		Container c1 =new Container();
		Container c2 =new Container();
		Container c3 =new Container();
		Container c4=new Container();
	    GridLayout g =new GridLayout(3,3);
	    p.setLayout(g);
	    g.setHgap(70);
	    g.setVgap(150);
		p.add(etudiant);
		p.add(jc1);
		p.add(c1);
		p.add(prof);
		p.add(jc2);
		p.add(c2);
		p.add(c3);
		p.add(inscre);
		p.add(c4);
		this.add(p, BorderLayout.CENTER);
}
private void colsing() {
	this.dispose();
}
private void executer() {
	jc1.addActionListener(new ActionListener() {     
	     @Override
	     public void actionPerformed(ActionEvent e) {
	         s1=jc1.getSelectedItem().toString();      
	     }
	   });
	jc2.addActionListener(new ActionListener(){     
	     @Override
	     public void actionPerformed(ActionEvent e) {
	         s2=jc2.getSelectedItem().toString();      
	     }
	   });
    inscre.addActionListener(new ActionListener() {
			@Override
        public void actionPerformed(ActionEvent e) {
				try {
					controleur.inprjet(s1,s2);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				colsing();
			}
		});
}

}
