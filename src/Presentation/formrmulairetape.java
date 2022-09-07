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

public class formrmulairetape extends JFrame{
	
		private JLabel labelid_projet;
		private JLabel labelidetape;
		private JLabel labeleduree;
		private JLabel labeletape_depart;
		private JTextField textidetape;
		private JTextField textduree;
		private JTextField textetape_depart;
		private JButton valider;
		private Integer id_projet;
		private Controleur controleur;
			
		 public  formrmulairetape(Controleur controleur,Integer id_projet){
			    this.id_projet=id_projet;
				this.setTitle("Formulaire");
				this.setSize(500, 500);
				this.initialiser(controleur);
				this.dessinner();
				this.executer();
			}
			
		private void initialiser( Controleur controleur) {
			    labelid_projet=new JLabel("projet "+id_projet);
				labelidetape= new JLabel("id_etape");
				labeleduree = new JLabel("duree etape");
				labeletape_depart = new JLabel("etape de depart");
				this.textidetape= new JTextField(20); 
				this.textduree= new JTextField(20); 
				this.textetape_depart= new JTextField(20);
				valider = new JButton("valider");
				this.controleur=controleur;
			}
		private void dessinner() {
				this.setLayout(new BorderLayout());
				JPanel p = new JPanel();
				p.setLayout(new GridLayout(7,1));
				p.add(labelid_projet);
				p.add(labelidetape);
				p.add(textidetape);
				p.add(labeleduree);
				p.add(textduree);
				p.add(labeletape_depart);
				p.add(textetape_depart);
				this.add(p, BorderLayout.CENTER);
				JPanel p1 = new JPanel();
				p1.setLayout(new GridLayout(1,1));
				p1.add(valider);
				this.add(p1 , BorderLayout.SOUTH);
				
			}
		private void colsing() {
				this.dispose();
			}
		private void executer() {
				valider.addActionListener(
						new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
	     try {
			controleur.valideretape(Integer.parseInt(textidetape.getText()), textduree.getText() , textetape_depart.getText(),Integer.parseInt(labelid_projet.getText().substring(7)) ) ;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	         
	          colsing();	}
							
						});
								
				
		}}

		


