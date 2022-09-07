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

import Metier.*;
import Persistance.*;
	public class formlabo extends JFrame {
		private JLabel labelInscrption;
		private JLabel labelidlabo;
		private JLabel labelemailabo;
		private JLabel labelnomlabo;
		private JTextField textidl;
		private JTextField textNoml;
		private JTextField textemailabo;
		private JButton inscrire;
		private Integer id=null;
		private Controleur controleur;
		
		 public  formlabo(Controleur controleur){
			this.setTitle("Formulaire");
			this.setSize(500, 500);
			this.initialiser(controleur);
			this.dessinner();
			this.executer();
		}
		public  formlabo(laboratoire l, Controleur controleur)  {
			this(controleur);
			this.id=l.getId_labo();
			this.textidl.setText(l.getId_labo().toString()); 
			this.textNoml.setText(l.getNom_labo()); 
			this.textemailabo.setText(l.getEmail_labo());
			
		}
		
		private void initialiser( Controleur controleur) {
			labelidlabo = new JLabel("id_laboratoire");
			labelnomlabo = new JLabel("nom_laboratoire");
			labelemailabo = new JLabel("email_laboratoire");
			this.textidl= new JTextField(30); 
			this.textNoml= new JTextField(30); 
			this.textemailabo= new JTextField(30);
			inscrire = new JButton("inscrire");
			this.controleur=controleur;
		}
		private void dessinner() {
			this.setLayout(new BorderLayout());
			
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(6,1));
			p.add(labelidlabo);
			p.add(textidl);
			p.add(labelnomlabo);
			p.add(textNoml);
			p.add(labelemailabo);
			p.add(textemailabo);
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
    	 if(id==null) {
		controleur.validerlabo(Integer.parseInt(textidl.getText()), textNoml.getText() , textemailabo.getText() ) ;
    	 }
    	 else{
       controleur.modifierlabo(id,Integer.parseInt(textidl.getText()), textNoml.getText() , textemailabo.getText() ) ;
    	 }
     } catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
         
          colsing();	}
						
					});
							
			
	}}

	
