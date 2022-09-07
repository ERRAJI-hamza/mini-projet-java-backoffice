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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Metier.etudiant;
import Metier.professeur;
import Metier.etudiant;
        
		public class FormulairePrf  extends JFrame {
				private JLabel labelInscrption;
				private JLabel labelNom;
				private JLabel labelrole;
				private JLabel labelPrenom;
				private JLabel labelEmail;
				private JLabel labelGrade;
				private JLabel labelLabo;
				private JLabel labelFilier;
				private JLabel labelDepartement;
				private JLabel labelCONfirmedPassword;
				private JLabel labelPassword;
				private JLabel Deja;
				private JLabel identifierVous;
				private JTextField textNom;
				private JTextField textPrenom;
				private JTextField textEmail;
				private JTextField textGrade;
				private JTextField textDepartement;
				private JTextField textlabo;
				private JTextField textfiliere;
				private JTextField textPassword;
				private JTextField textCONfirmedPassword;
				private JComboBox jc;
				private JButton inscrire;
				private String s1,s2;
				private JComboBox jc1;
				private Integer id_prof=null;
				private Controleur controleur;
				
				public FormulairePrf(Controleur controleur) {
					this.setTitle("FormulairePrfPrf");
					this.setSize(600, 700);
					this.initialiser(controleur);
					this.dessinner();
					this.executer();
				}
				public FormulairePrf(professeur etud, Controleur controleur)  {
					this(controleur);
					this.id_prof=etud.getId_prof();
					this.textNom.setText(etud.getNom_prof()); 
					this.textPrenom.setText(etud.getPrenom_prof()); 
					this.textEmail.setText(etud.getEmail_prof());
					this.textfiliere.setText(etud.getNom_filiere());
					this.textlabo.setText(((Integer)etud.getId_labo()).toString());	
					
					this.textDepartement.setText(etud.getNom_departement()); 
					this.textPassword.setText(etud.getPassword());
					
				}
				
				private void initialiser( Controleur controleur) {
					jc =new JComboBox();
					jc.addItem("membre");
					jc.addItem("chef_filiere");
					labelInscrption=new JLabel("Inscription");
					labelNom = new JLabel("Nom");
					labelPrenom = new JLabel("Prenom");
					labelEmail = new JLabel("Adresse  Email");
					 labelPassword = new JLabel("Mot de passe");
					labelCONfirmedPassword = new JLabel("confirmed mot de passe");
					labelFilier = new JLabel("filier");
					labelLabo = new JLabel("laboratoire");
					labelGrade = new JLabel("Grade");
					labelDepartement = new JLabel("Departement");
					labelrole = new JLabel("role");
					Deja = new JLabel("si vous avez deja un compte"); ;
					identifierVous= new JLabel("identifier Vous"); 
					jc1 = new JComboBox();
					jc1.addItem("PES");
					jc1.addItem("PH");
					
					this.textNom= new JTextField(30); 
					this.textPrenom= new JTextField(30); 
					this.textEmail= new JTextField(30);
					textDepartement = new JTextField(30); 
					this.textPassword = new JTextField(30);
					this.textCONfirmedPassword = new JTextField(30);
					this.textlabo  =new JTextField(30);
					this.textfiliere=new JTextField(30);
					
					inscrire = new JButton("inscrire");
					this.controleur=controleur;
				}
				private void dessinner() {
					this.setLayout(new BorderLayout());
				//insciption et nom et prenom dans north lkbir
					
					JPanel north = new JPanel();
					north.setLayout(new GridLayout(3,2));
					Container contenaireKhawiLfo9 = new Container();
					contenaireKhawiLfo9.setPreferredSize(new Dimension(100,50));
					
					north.add(labelInscrption);
					north.add(contenaireKhawiLfo9);
					north.add(labelNom);
					north.add(labelPrenom);
					north.add(textNom);
					north.add(textPrenom);
					
					this.add(north, BorderLayout.NORTH);
				// adresse et mot pass et confirmed motpass
					
					JPanel centre = new JPanel();
					centre.setLayout(new GridLayout(8,1));
					centre.add(labelEmail);
					centre.add(textEmail);
					centre.add(labelPassword);
					centre.add(textPassword);
					centre.add(labelCONfirmedPassword);
					centre.add(textCONfirmedPassword);
                    centre.add(labelrole);
                    centre.add(jc);
					this.add(centre, BorderLayout.CENTER);
					//
					
					JPanel south = new JPanel();
					south.setLayout(new BorderLayout());
					
					
					
				// 2 radio 	wlita7tha
					
					
					JPanel centre2 = new JPanel();
					centre2.setLayout(new GridLayout(9,1));
					
					
					
					centre2.add(labelFilier);
					centre2.add(textfiliere);
					centre2.add(labelLabo);
					centre2.add(textlabo);
					centre2.add(labelGrade);
					centre2.add(jc1);
					centre2.add(labelDepartement);
					centre2.add(textDepartement);
					centre2.add(inscrire);//inscrire button
					
					
					
				
					south.add(centre2, BorderLayout.CENTER);
					
					
					
					this.add(south, BorderLayout.SOUTH);
					
					
				}
				private void colsing() {
					this.dispose();
				}
				private void executer() {
					/* inscrire.addActionListener(
							new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									/*controleur.modifierFormulairePrf(textNom.getText()
									,textPrenom.getText(),textEmail.getText());
									colsing();	}
								
							});*/
									
					jc.addActionListener(new ActionListener() {     
					     @Override
					     public void actionPerformed(ActionEvent e) {
					         s1=jc.getSelectedItem().toString();      
					     }
					   });
					
					jc1.addActionListener(new ActionListener() {     
					     @Override
					     public void actionPerformed(ActionEvent e) {
					         s2=jc1.getSelectedItem().toString();      
					     }
					   });
					inscrire.addActionListener(
							new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
		try {
			if(id_prof==null)
			controleur.validerFormulaire(textNom.getText(), textPrenom.getText(),s2,textEmail.getText(),
					 Integer.parseInt(textlabo.getText()), textfiliere.getText(),  textDepartement.getText(), textPassword.getText(),s1,textCONfirmedPassword.getText()) ;
			else {
				controleur.modifpr(id_prof, textNom.getText(), textPrenom.getText(),s2,textEmail.getText(),
					 Integer.parseInt(textlabo.getText()), textfiliere.getText(),  textDepartement.getText(), textPassword.getText(),s1,textCONfirmedPassword.getText()) ;}
		} catch (NumberFormatException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		colsing();	}
								
							});
								
				
			}}

			
