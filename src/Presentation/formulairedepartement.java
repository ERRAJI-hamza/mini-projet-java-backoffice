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

import Metier.departement;
import Metier.etudiant;
import Metier.filiere;
import Metier.etudiant;
import Persistance.*;
	public class formulairedepartement extends JFrame {
		private JLabel labelInscrption;
		private JLabel labelNomd;
		private JLabel labelemaild;
		private JTextField textNomd;
		private JTextField textemaild;
		private JButton inscrire;
		private int i=0;
		private Controleur controleur;
		
		 public formulairedepartement(Controleur controleur){
			this.setTitle("Formulaire");
			this.setSize(500, 500);
			this.initialiser(controleur);
			this.dessinner();
			this.executer();
		}
		
		public formulairedepartement(departement dp, Controleur controleur, int i) {
			this(controleur);
			this.i=i;
			if(i==1) {
				this.setSize(500, 250);
				labelNomd.setVisible(false);
				textNomd.setVisible(false);
				this.textNomd.setText(dp.getNom_departement()); 
				this.textemaild.setText(dp.getEmail_departement()); 	
			}
		}
		
		private void initialiser( Controleur controleur) {
			labelNomd = new JLabel("nom_departement");
			labelemaild = new JLabel("email_departement");
			this.textNomd= new JTextField(30); 
			this.textemaild= new JTextField(30); 
			inscrire = new JButton("inscrire");
			this.controleur=controleur;
		}
		private void dessinner() {
			this.setLayout(new BorderLayout());
			
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(4,1));
			p.add(labelNomd);
			p.add(textNomd);
			p.add(labelemaild);
			p.add(textemaild);
			
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
		controleur.validerdepartement(textNomd.getText(), textemaild.getText(),i) ;
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
         
          colsing();	}
						
					});
							
			
	}}

	
