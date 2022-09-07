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

import Metier.entreprise;
import Metier.etudiant;
import Metier.filiere;
import Metier.etudiant;
import Persistance.*;
    public class formEntrprs extends JFrame {
		private JLabel labelInscrption;
		private JLabel labelResponsable_Es;
		private JLabel labelemaild;
		private JLabel labelTele_ES;
		private int z=0;
		
		private JTextField textRespon;
		private JTextField textemaild;
		private JTextField textTele_ES;
		private JTextField textid;
		private JButton inscrire;
		private Controleur controleur;
		private int a = 0;
		
		 public formEntrprs(Controleur controleur){
			this.setTitle("Formulaire");
			this.setSize(500, 500);
			this.initialiser(controleur);
			this.dessinner();
			this.executer();
		}
		public formEntrprs(entreprise dp, Controleur controleur)  {
			this(controleur);
            this.textemaild.setText(dp.getEmail_ES()); 
			this.textid.setText(dp.getId_Es().toString());
			this.textTele_ES.setText(dp.getTele_ES()); 
			this.textRespon.setText(dp.getResponsable_Es()); 
		}
		
		public formEntrprs(entreprise dp, Controleur controleur, int i) {
			// TODO Auto-generated constructor stub
			this(controleur);
			if(i==1) {
				a=i;
				z=dp.getId_Es();
				this.setSize(500, 250);
				labelInscrption.setVisible(false);
				textid.setVisible(false);
				this.textemaild.setText(dp.getEmail_ES()); 
				
				this.textTele_ES.setText(dp.getTele_ES()); 
				
				this.textRespon.setText(dp.getResponsable_Es());
			}
		}
		private void initialiser( Controleur controleur) {
			labelInscrption=new JLabel("id_Entreprise");
			labelTele_ES=new JLabel("teleEntrprs");
			this.textTele_ES=new JTextField(30); 
			this.textid= new JTextField(30);
			labelResponsable_Es = new JLabel("responsable_Entrs");
			labelemaild = new JLabel("email_entreprise");
			this.textRespon= new JTextField(30); 
			this.textemaild= new JTextField(30); 
			inscrire = new JButton("inscrire");
			this.controleur=controleur;
		}
		private void dessinner() {
			this.setLayout(new BorderLayout());
			
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(4,2));
			p.add(labelInscrption);
			p.add(textid);
			p.add(labelResponsable_Es);
			p.add(textRespon);
			p.add(labelemaild);
			p.add(textemaild);
			p.add(labelTele_ES);
			p.add(textTele_ES);
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
    	 if (a == 0) {
 			z = Integer.parseInt(textid.getText());
    	 }
 		controleur.validerentreprise(z,textemaild.getText(),textTele_ES.getText(),textRespon.getText(), a) ;
	} catch (NumberFormatException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
         
          colsing();	}
						
					});
							
			
	}}