package Presentation;

import javax.swing.JFrame;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import Metier.etudiant;
import Metier.etudiant;
import Persistance.*;

public class formulairePfe extends JFrame{
            
	  private JLabel date_debut;
	  private JLabel duree;
	  private JTextField tdate_debut;
 	  private JComboBox<String>  lduree;
 	  private JRadioButton labo;
 	  private JRadioButton Es;
 	  private ButtonGroup G;
 	  private JTextField textlabo;
 	  private JTextField textEs;
 	  private Controleur controleur;
 	  private JButton affectation;
 	  private String s1;
 	  private String s[]={"5 mois" , "6 mois"};
 	  
 	public formulairePfe(Controleur controleur) {
			this.setTitle("Formulaire");
			this.setSize(500, 500);
			this.initialiser(controleur);
			this.dessinner();
			this.executer();
		}
 	private void initialiser( Controleur controleur) {
		date_debut = new JLabel("date_debut");
		duree = new JLabel("dure");
		tdate_debut=new JTextField("fevrie");
        labo = new JRadioButton("laboratoire");
        Es = new JRadioButton("entreprise");
        G = new ButtonGroup();
        textlabo =new JTextField(10);
        textEs= new JTextField(10);
        lduree = new JComboBox<String>(s);
        affectation =new JButton("affectation");
		this.controleur=controleur;
	}
 	private void dessinner() {
		this.setLayout(new BorderLayout());
		G.add(labo);G.add(Es);
		JPanel p =new JPanel();
		p.setLayout(new BorderLayout());
		JPanel p1 =new JPanel();
		p1.setLayout(new GridLayout(2,4));
		Container c1= new Container();
		Container c2= new Container();
		Container c3= new Container();
		Container c4= new Container();
		p1.add(date_debut);p1.add(tdate_debut);p1.add(c1);p1.add(c2);
		p1.add(duree);p1.add(lduree);p1.add(c3);p1.add(c4);
		p.add(p1, BorderLayout.NORTH);
		JPanel p2 =new JPanel();
		p2.setLayout(new GridLayout(5,1));
		p2.add(labo);p2.add(textlabo);p2.add(Es);p2.add(textEs);
		p2.add(affectation);
		p.add(p2 , BorderLayout.CENTER);
		this.add(p,BorderLayout.CENTER);
		
	}
	private void colsing() {
		this.dispose();
	}
	private void executer() {
		lduree.addActionListener(new ActionListener() {     
		     @Override
		     public void actionPerformed(ActionEvent e) {
		         s1=lduree.getSelectedItem().toString();      
		     }
		   });
		 affectation.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if(labo.isSelected()) { Integer str=Integer.parseInt(textlabo.getText());int k=1;
								controleur.fnprj(tdate_debut.getText(),s1,str,k);}
								else if(Es.isSelected()) { Integer str=Integer.parseInt( textEs.getText());int k=2;
								controleur.fnprj(tdate_debut.getText(),s1,str,k);}
	
								
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							colsing();
							
						}
						
					});
	}}
