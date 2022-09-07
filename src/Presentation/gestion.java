package Presentation;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import Metier.*;

public class gestion extends JFrame	{

		private JLabel titre;
		private JButton etudiant;
		private JButton professeur;
		private JButton projet;
		private JButton laboratoire;
		private JButton entreprise;
		private JButton departement;
		private JButton filiere;
		private Controleur controleur;
		

		public gestion( Controleur controleur) {
			this.setTitle("Formulaire");
			this.setSize(500, 300);
			this.initialiser( controleur);
			this.dessinner();
			this.executer();
			 
		}
		private void initialiser( Controleur controleur) {
			titre = new JLabel("gestion : ");
			professeur = new JButton("professeur");
			etudiant= new JButton("etudiant");
			laboratoire = new JButton("laboratoire ");
			entreprise = new JButton("entreprise");
			departement = new JButton("departement");
			projet = new JButton("projet");
			filiere = new JButton("filiere");
			
			this.controleur=controleur;
		}
		private void dessinner() {
			this.setLayout(new BorderLayout());
			
			JPanel jp2=new JPanel();
			jp2.setLayout(new GridLayout(1,3));
			jp2.add(titre);
			jp2.add(new Container());
			jp2.add(new Container());
			this.add(jp2, BorderLayout.NORTH);
			
			JPanel jp=new JPanel();
			jp.setLayout(new GridLayout(4,3));
			
			jp.add(new Container());
			professeur.setBounds(200, 100, 200, 50);
			jp.add(professeur);
			jp.add(new Container());
			
			etudiant.setBounds(200,160,200,50);
            jp.add(etudiant);
            jp.add(new Container());
			
            projet.setBounds(200,220,200,50);
            jp.add(projet);
            
            laboratoire.setBounds(200,340,200,50);
            jp.add(laboratoire);
            jp.add(new Container());
			
            entreprise.setBounds(200,400,200,50);
            jp.add(entreprise);
            
			
            filiere.setBounds(200,460,200,50);
            jp.add(filiere);
            jp.add(new Container());
            departement.setBounds(200,520,200,50);
            jp.add(departement);
			this.add(jp , BorderLayout.CENTER);
			
		}
		private void colsing() {
			this.dispose();
		}
		private void executer() {
			professeur.addMouseListener((MouseListener) new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					try {
						controleur.gestionprof();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			etudiant.addMouseListener((MouseListener) new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					try {
						controleur.gestionetud();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
		filiere.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					controleur.gestionfiliere();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		departement.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					controleur.gestiondepartement();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		laboratoire.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					controleur.gestionlabo();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		projet.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					controleur.gestionprojet();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		entreprise.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					controleur.gestionentreprise();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
	}