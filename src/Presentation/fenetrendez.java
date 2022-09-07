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

public class fenetrendez extends JFrame{
	      private ArrayList<rendez>list;
          private JTable table;
          private JButton ajouter;
          private JButton superimer;
          private JButton modification;
          private JButton edition;
          private Controleur controleur;
          private JPanel p;
          private Integer n;
          private Object source;
		public fenetrendez(Controleur controleur ,ArrayList<rendez>list ,Integer n) throws HeadlessException {
			super();  
			this.n=n;
			this.setSize(500, 300);
			setVisible(true);
			this.list = list;
			this.initialiser(controleur , list);
			this.dessinner();
			this.executer1();
		}
		public fenetrendez(Controleur controleur ,ArrayList<rendez>list) throws HeadlessException {
			super();  
			this.setSize(500, 300);
			setVisible(true);
			this.list = list;
			this.initialiser(controleur , list);
			this.dessinner();
			ajouter.setVisible(false);
			this.executer1();
			ajouter.setVisible(false);
		}
		private void initialiser(Controleur controleur , ArrayList<rendez>list){
			modelerv listArct = new modelerv(list);
			table = new JTable();
			table.setModel(listArct);
			table.addMouseListener(new MouseAdapter(){
				public	void mouseClicked(MouseEvent ev){
					       int index = table.getSelectedRow();
			
				     }
			     });
			table.setFillsViewportHeight(true);
			ajouter = new JButton("ajouter");
			p = new JPanel();
			this.controleur=controleur;
		  }
		private void dessinner() {
			this.setLayout(new BorderLayout());
			this.add(new JScrollPane(table), BorderLayout.NORTH);
			p.setLayout(new GridLayout(1,1));
			p.add(ajouter);
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
								try {
									controleur.formsrv(n);
								} catch (ClassNotFoundException e1) {
									e1.printStackTrace();
								}
								colsing();
								
							}
							
						});
		
								
		}}
						
		
	

