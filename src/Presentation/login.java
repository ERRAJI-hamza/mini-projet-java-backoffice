package Presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Metier.etudiant;
import Metier.professeur;



public class login extends JFrame {

	private JLabel labelInscrption;
	private JLabel labelid;
	private JLabel labelPassword;
	private JTextField textid;
	private JTextField textPasswor;
	private JButton inscrire;
			
	private Controleur controleur;
	

	public login( Controleur controleur) {
		this.setTitle("Formulaire");
		this.setSize(500, 300);
		this.initialiser( controleur);
		this.dessinner();
		this.executer();
		 
	}
	public login(etudiant etud, Controleur controleur)  {
		this(controleur);
		 
		this.textid.setText(etud.getId().toString());
		 
		this.textPasswor.setText(etud.getPassword());
		
	}
	public login(professeur etud, Controleur controleur) {
		this(controleur);
		 
		this.textid.setText(etud.getId_prof().toString());
		 
		this.textPasswor.setText(etud.getPassword());
		
	}
	private void initialiser( Controleur controleur) {
		
		labelInscrption=new JLabel("Inscription");
		
		labelid = new JLabel("id");
		 labelPassword = new JLabel("Mot de passe");
		
		 
		this.textid= new JTextField(30);
		
		
		this.textPasswor = new JTextField(30);
		
		
		inscrire = new JButton("inscrire");
		this.controleur=controleur;
	}
	private void dessinner() {
		this.setLayout(new BorderLayout());

		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1,2));
		Container contenaireKhawiLfo9 = new Container();
		contenaireKhawiLfo9.setPreferredSize(new Dimension(100,100));
		
		north.add(labelInscrption);
		north.add(contenaireKhawiLfo9);
		
		
		this.add(north, BorderLayout.NORTH);
	
		
		JPanel centre = new JPanel();
		centre.setLayout(new GridLayout(5,1));
	    centre.add(labelid);
		centre.add(textid);
		centre.add(labelPassword);
		centre.add(textPasswor);
		centre.add(inscrire);
	
		this.add(centre, BorderLayout.CENTER);
		
		
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1,2));
		
	 
		this.add(south, BorderLayout.SOUTH);
		
		
	}
	private void colsing() {
		this.dispose();
	}
	private void executer() {
		
		inscrire.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					controleur.SinscrireProfil(Integer.parseInt( textid.getText()),textPasswor.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				colsing();
			}
		});
		
	}
}