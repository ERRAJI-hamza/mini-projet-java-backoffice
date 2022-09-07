package Presentation;


	import java.awt.*;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;

	import javax.swing.*;
	import Metier.*;
public class frontprof extends JFrame{
	

	
	private JButton projet;
	private JButton rendezvous;
	private Controleur controleur;
    private  Integer id_prof;	

			public frontprof( Controleur controleur , Integer id_prof) {
				this.id_prof=id_prof;
				this.setTitle("Formulaire");
				this.setSize(500, 300);
				this.initialiser( controleur);
				this.dessinner();
				this.executer();
				 
			}
			private void initialiser( Controleur controleur) {
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
			private void colsing() {
				this.dispose();
			}
			private void executer() {
				projet.addMouseListener((MouseListener) new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						try {
							controleur.fntped(id_prof);
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
							controleur.fntrendezprof(id_prof);
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
						
					}
				});
		}



}