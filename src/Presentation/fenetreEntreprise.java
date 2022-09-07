package Presentation;

import Metier.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class fenetreEntreprise extends JFrame{
	      private ArrayList<entreprise>list;
          private JTable table;
          private JButton ajouter;
          private JButton superimer;
          private JButton modification;
          
          private Controleur controleur;
          private JPanel p;
          private Object source;
          private entreprise dp;
		public fenetreEntreprise(Controleur controleur ,ArrayList<entreprise>list) throws HeadlessException {
			super();  
			this.setSize(500, 300);
			setVisible(true);
			this.list = list;
			this.initialiser(controleur , list);
			this.dessinner();
			this.executer1();
			this.executer2();

			this.executer3();
		}
		private void initialiser(Controleur controleur , ArrayList<entreprise>list){
			modulentreprise listArct = new modulentreprise(list);
			table = new JTable();
			table.setModel(listArct);
			table.addMouseListener(new MouseAdapter(){
				public	void mouseClicked(MouseEvent ev){
					       int index = table.getSelectedRow();
					       Integer id_entr=Integer.parseInt(listArct.getValueAt(index, 0).toString());					    
					       String Email= listArct.getValueAt(index, 1).toString();
					       String tele= listArct.getValueAt(index, 2).toString();
					       String RESponsable= listArct.getValueAt(index,3).toString();
					       
					       dp=new entreprise(id_entr, Email,tele,RESponsable);
				     }
			     });
			table.setFillsViewportHeight(true);
			ajouter = new JButton("ajouter");
			superimer= new JButton("superimer");
			modification= new JButton("modification");
			
			p = new JPanel();
			this.controleur=controleur;
		  }
		private void dessinner() {
			this.setLayout(new BorderLayout());
			this.add(new JScrollPane(table), BorderLayout.NORTH);
			p.setLayout(new GridLayout(1,3));
			p.add(ajouter);
			p.add(modification);
			
			p.add(superimer);
			this.add(p,BorderLayout.SOUTH);
			pack();
		}
		private void colsing() {
			this.dispose();
		}
		private void executer1() {
			 ajouter.addActionListener(
						new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controleur.formEnt();
								colsing();
								
							}
							
						});
		}
		private void executer2(){
			 superimer.addActionListener(
						new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									controleur.superimerentreprise(dp);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								colsing();
								
							}
							
						});
		}
			 private void executer3() {
					// TODO Auto-generated method stub
					 modification.addActionListener(
								new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										controleur.modifierentreprise(dp);
										colsing();
										
									}
									
								});
		}
		
	
          
}