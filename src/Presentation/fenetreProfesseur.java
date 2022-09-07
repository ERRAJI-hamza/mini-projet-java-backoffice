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

public class fenetreProfesseur extends JFrame{
	      private ArrayList<professeur>list;
          private JTable table;
          private JButton ajouter;
          private JButton superimer;
          private JButton modification;
          private Controleur controleur;
          private JPanel p;
          private Object source;
          private professeur pr;
          private modeleprofesseur listAt;
		public fenetreProfesseur(Controleur controleur ,ArrayList<professeur>list) throws HeadlessException {
			super();  
			this.setSize(500, 300);
			setVisible(true);
			this.list = list;
			this.initialiser(controleur , list);
			this.dessinner();
			this.executer1();
			this.executer2();
		}
		private void initialiser(Controleur controleur , ArrayList<professeur>list){
			        listAt = new modeleprofesseur(list);
			        table  = new JTable();
			        table.setModel(listAt);
			        table.addMouseListener(new MouseAdapter(){
			     	public	void mouseClicked(MouseEvent ev){
					       int index = table.getSelectedRow();
					       Integer pid= Integer.parseInt(listAt.getValueAt(index, 0).toString());
					       String pnom= listAt.getValueAt(index, 1).toString();
					       String pprenom= listAt.getValueAt(index, 2).toString();
					       String pgrade= listAt.getValueAt(index, 3).toString();
					       String pemail= listAt.getValueAt(index, 4).toString();
					       Integer pid_labo=Integer.parseInt(listAt.getValueAt(index, 7).toString());
					       String pfiliere= listAt.getValueAt(index, 6).toString();
					       String pdepartement= listAt.getValueAt(index, 5).toString();
					       String ppassword= listAt.getValueAt(index, 8).toString();
					       String prole= listAt.getValueAt(index, 9).toString();
					       pr=new professeur(pid,pnom,pprenom,pgrade,pemail,pid_labo,pfiliere,pdepartement,ppassword,prole);
				     }
			     });
			
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
								controleur.EtudToProf();
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
									controleur.superimerprof(pr);
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								colsing();
								
							}
							
						});
			 modification.addActionListener(
						new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controleur.modifierprof(pr);
								colsing();
								
							}
							
						});
		}
	
          
}
