package Presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Metier.etudiant;
import Metier.etudiant;
import Persistance.*;
	public class Formulaire extends JFrame {
		
		Daoetudiant dao ;
		
		private JLabel labelInscrption;
		private JLabel labelNom;
		private JLabel labelPrenom;
		private JLabel labelEmail;
		private JLabel labelFiliere;
		private JLabel labelNiveau;
		private JLabel labelCONfirmedPassword;
		private JLabel labelPassword;
		private JTextField textNom;
		private JTextField textPrenom;
		private JTextField textEmail;
		private JTextField textFiliere;
		private JComboBox Niveau=new JComboBox();
		private JTextField textPassword;
		private JTextField textCONfirmedPassword;
		private JButton inscrire;
		private Controleur controleur;
		
		public Formulaire(Controleur controleur) {
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Formulaire");
			this.setSize(550, 650);
			this.initialiser(controleur);
			this.dessinner();
			this.executer();
		}
		public Formulaire(etudiant etud, Controleur controleur)  {
			this(controleur);
			this.textNom.setText(etud.getName()); 
			this.textPrenom.setText(etud.getPrenom()); 
			this.textEmail.setText(etud.getEmail());
			this.textFiliere.setText(etud.getFiliere()); 
			this.Niveau.setSelectedItem(etud.getNiveau()); 
			this.textPassword.setText(etud.getPassword());
			
		}
		
		private void initialiser( Controleur controleur) {
			
			labelInscrption=new JLabel("Inscription");
			labelNom = new JLabel("Nom");
			labelPrenom = new JLabel("Prenom");
			labelEmail = new JLabel("Adresse  Email");
			 labelPassword = new JLabel("Mot de passe");
			labelCONfirmedPassword = new JLabel("confirmed mot de passe");
			labelFiliere = new JLabel("Filier");
			labelNiveau = new JLabel("Niveau");
			
			this.textNom= new JTextField(30); 
			this.textPrenom= new JTextField(30); 
			this.textEmail= new JTextField(30);
			this.textFiliere = new JTextField(30); 
			this.Niveau.addItem("4eme anne");
			this.Niveau.addItem("5eme anne");
			this.Niveau.addItem("Doctorat");
			this.textPassword = new JTextField(30);
			this.textCONfirmedPassword = new JTextField(30);
			
			inscrire = new JButton("inscrire");
			this.controleur=controleur;
		}
		private void dessinner() {
			this.setLayout(new BorderLayout());
		//insciption et nom et prenom dans north lkbir
			
			JPanel north = new JPanel();
			north.setLayout(new GridLayout(3,2, 4,2));
			Container contenaireKhawiLfo9 = new Container();
			contenaireKhawiLfo9.setPreferredSize(new Dimension(50,50));
			
			north.add(labelInscrption);
			north.add(contenaireKhawiLfo9);
			
			north.add(labelNom);
			north.add(labelPrenom);
			north.add(textNom);
			north.add(textPrenom);
			
			
			this.add(north, BorderLayout.NORTH);
		// adresse et mot pass et confirmed motpass
			
			JPanel centre = new JPanel();
			centre.setLayout(new GridLayout(6,1));
			centre.add(labelEmail);
			centre.add(textEmail);
			centre.add(labelPassword);
			centre.add(textPassword);
			centre.add(labelCONfirmedPassword);
			centre.add(textCONfirmedPassword);
		
			this.add(centre, BorderLayout.CENTER);
			//
			
			JPanel south = new JPanel();
			south.setLayout(new BorderLayout());
			
			
			
		// 2 radio 	wlita7tha
			
			JPanel centre2 = new JPanel();
			centre2.setLayout(new GridLayout(5,1));
			
			JPanel south2 = new JPanel();
			south2.setLayout(new GridLayout(1,2));
			
			
			
			centre2.add(labelFiliere);
			centre2.add(textFiliere);
			centre2.add(labelNiveau);
			centre2.add(Niveau);
			centre2.add(inscrire);//inscrire button
			
			//inscrire et deja 
			
			//south.add(north2, BorderLayout.NORTH);
			
		
			south.add(centre2, BorderLayout.CENTER);
			
			
			south.add(south2, BorderLayout.SOUTH);
			//suath glob
			
			this.add(south, BorderLayout.SOUTH);
			
			
		}
		private void colsing() {
			this.dispose();
		}
		private void executer() {
			inscrire.addActionListener(
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
     try {
		controleur.validerProfil(textNom.getText(), textPrenom.getText(), textEmail.getText(),
			textFiliere.getText(), Niveau.getSelectedItem().toString(), textPassword.getText(),textCONfirmedPassword.getText()) ;
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
         
          colsing();	}
						
					});
							
		
	}
		

}