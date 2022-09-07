package Presentation;

import java.awt.BorderLayout;
import java.awt.Button;
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
import Metier.*;
import Persistance.*;

public class formulaireprojet extends JFrame{
		   
	        private JLabel titre;
	        private JTextField textTitre;
	        private JRadioButton j1;
	        private JRadioButton j2;
	        private JRadioButton j3;
	        private ButtonGroup G1;
	        private JButton continuer;
	        private Controleur controleur;
	       public formulaireprojet(Controleur controleur) {
				this.setTitle("Formulaire");
				this.setSize(500, 500);
				this.initialiser(controleur);
				this.dessinner();
				this.executer();
			}
			public formulaireprojet(projet prj, Controleur controleur)  {
				this(controleur);
			    
				
			}
			
			private void initialiser( Controleur controleur) {
				titre = new JLabel("titre");
				textTitre = new JTextField(30);
				j1 = new JRadioButton("projet fin d'etude");
				j2 = new JRadioButton("projet fin an");
				j3 = new JRadioButton("Doctora");
				G1 = new ButtonGroup();
				continuer = new JButton("continuer");
				this.controleur=controleur;
			}
			private void dessinner() {
				 G1.add(j1);G1.add(j2);G1.add(j3);
				 JPanel p = new JPanel();
				 JPanel p2 = new JPanel();
				 p2.setLayout(new GridLayout(3,1));
				 p.setLayout(new GridLayout(1,3));
				 Container c1= new Container();
				 Container c2= new Container();
				 p.add(titre);p.add(textTitre);p.add(c1);
				 p2.add(j1);p2.add(j2);p2.add(j3);
				 JPanel p1 = new JPanel();
				 JPanel p3 = new JPanel();
				 p3.setLayout(new GridLayout(1,1));
				 p3.add(continuer);
				 p1.setLayout(new BorderLayout());
				 p1.add(p,BorderLayout.NORTH);
				 p1.add(p2,BorderLayout.CENTER);
				 p1.add(p3,BorderLayout.SOUTH);
				 this.add(p1,BorderLayout.CENTER);
			}
			private void colsing() {
				this.dispose();
			}
			private void executer() {
				continuer.addActionListener(
						new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
	     try {
			     if(j1.isSelected()) {
			    	 controleur.pfe(textTitre.getText(),j1.getText());
			     }
			    else if(j2.isSelected()){
			    	 controleur.pfa(textTitre.getText(),j2.getText());
			     }
			     else if(j3.isSelected()){
			     controleur.dr(textTitre.getText(),j3.getText());
			     }
		} catch (Exception  e1) {
			e1.printStackTrace();
		}
	         
	          colsing();	}
							
						});
			
			
		}}
