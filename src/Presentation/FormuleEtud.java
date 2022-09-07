package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Metier.etudiant;
import Metier.professeur;
import Metier.etudiant;

	public class FormuleEtud  extends JFrame {
		
		private JButton projet;
		private JButton rendezvous;
	    private  Integer id;
		private Controleur controleur;
		
		public FormuleEtud (Controleur controleur ,Integer id) {
			this.id=id;
			this.setTitle("Formulaire");
			this.setSize(500, 300);
			this.initialiser( controleur);
			this.dessinner();
			this.executer();
		}
		
		private void initialiser(Controleur controleur ) {
			projet = new JButton("projet");
			rendezvous= new JButton("rendezvous");
			this.controleur=controleur;
		}
		private void dessinner() {
this.setLayout(new BorderLayout());
			
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(4,1));
			p.add(new Container());
			p.add(projet);
			p.add(new Container());
			p.add(rendezvous);
			
			this.add(p, BorderLayout.CENTER);
			JPanel p1 = new JPanel();
			p1.setLayout(new GridLayout(1,1));
			p1.add(new Container());
			this.add(p1 , BorderLayout.SOUTH);
					}
		private void colsing(){
			this.dispose();
		}
		private void executer() {
			projet.addMouseListener((MouseListener) new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					try {
						controleur.fntetd(id);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
			rendezvous.addMouseListener((MouseListener) new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					try {
						controleur.fntrendezetd(id);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		}