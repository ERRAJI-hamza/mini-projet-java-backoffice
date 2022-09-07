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

public class fenetretudiant extends JFrame{
	      private ArrayList<etudiant>list;
          private JTable table;
          private JButton ajouter;
          private JButton superimer;
          private JButton modification;
          private Controleur controleur;
          private JPanel p;
          private Object source;
          private etudiant etu;
		public fenetretudiant(Controleur controleur ,ArrayList<etudiant>list) throws HeadlessException {
			super();  
			this.setSize(500, 300);
			setVisible(true);
			this.list = list;
			this.initialiser(controleur , list);
			this.dessinner();
			this.executer1();
			this.executer2();
		}
		private void initialiser(Controleur controleur , ArrayList<etudiant>list){
			moduletudiant listArct = new moduletudiant(list);
			table = new JTable(listArct);
			table.addMouseListener(new MouseAdapter(){
				public	void mouseClicked(MouseEvent ev){
					       int index = table.getSelectedRow();
					       Integer eid= Integer.parseInt(listArct.getValueAt(index, 0).toString());
					       String enom= listArct.getValueAt(index, 1).toString();
					       String eprenom= listArct.getValueAt(index, 2).toString();
					       String eemail= listArct.getValueAt(index, 3).toString();
					       String efiliere= listArct.getValueAt(index, 4).toString();
					       String eniveau=listArct.getValueAt(index, 5).toString();
					       String epassword= listArct.getValueAt(index, 6).toString();
					       etu=new etudiant(eid,enom,eprenom,eemail,efiliere,eniveau,epassword);
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
			p.setLayout(new GridLayout(1,2));
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
								controleur.ProfToEtud();
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
									controleur.superimeretudiant(etu);
								} catch (ClassNotFoundException e1) {
									e1.printStackTrace();
								}
								colsing();
								
							}
							
						});
			 modification.addActionListener(
						new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								controleur.modifiereEtd(etu);
								colsing();
								
							}
							
						});
		}
	
          
}
