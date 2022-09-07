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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Metier.etudiant;
import Metier.filiere;
import Metier.etudiant;
import Persistance.*;
	public class formulairefiliere extends JFrame {
		
		Daofiliere dao ;
		
		private JLabel labelInscrption;
		private JLabel labelNomf;
		private JLabel labelNomfd;
		private JTextField textNomf;
		private JTextField textNomfd;
		private JButton inscrire;
		private Controleur controleur;
		
		 public formulairefiliere(Controleur controleur){
			this.setTitle("Formulaire");
			this.setSize(500, 500);
			this.initialiser(controleur);
			this.dessinner();
			this.executer();
		}
		public formulairefiliere(filiere fi, Controleur controleur)  {
			this(controleur);
			this.textNomf.setText(fi.getNom_filiere()); 
			this.textNomfd.setText(fi.getNom_departement()); 
		}
		
		private void initialiser( Controleur controleur) {
			labelNomf = new JLabel("nom_filiere");
			labelNomfd = new JLabel("nom_departement");
			this.textNomf= new JTextField(30); 
			this.textNomfd= new JTextField(30); 
			inscrire = new JButton("inscrire");
			this.controleur=controleur;
		}
		private void dessinner() {
			this.setLayout(new BorderLayout());
			
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(4,1));
			p.add(labelNomf);
			p.add(textNomf);
			p.add(labelNomfd);
			p.add(textNomfd);
			
			this.add(p, BorderLayout.CENTER);
			JPanel p1 = new JPanel();
			p1.setLayout(new GridLayout(1,1));
			p1.add(inscrire);
			this.add(p1 , BorderLayout.SOUTH);
			
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
		controleur.validerfiliere(textNomf.getText(), textNomfd.getText()) ;
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
         
          colsing();	}
						
					});
							
			
	}}

	
