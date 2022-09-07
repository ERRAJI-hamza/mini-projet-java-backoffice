package Presentation;

import Metier.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class fenetredocument extends JFrame{
		 private ArrayList<document>list;
	     private JTable table;
	     private JButton idprojet;
	     private JButton ouvrir;
         private Controleur controleur;
         private JPanel p;
         String s="";
         private JTextField txtmotcle;
         private JLabel chercher;
         private Integer id_etape;
         private Object source;
         
         
		public fenetredocument(Controleur controleur ,ArrayList<document>list,Integer id_etape) throws HeadlessException {
				super();  
				this.id_etape=id_etape;
				this.setSize(500, 300);
				setVisible(true);
				this.list = list;
				this.initialiser(controleur , list);
				this.dessinner();
				this.executer1();
			}
			private void initialiser(Controleur controleur , ArrayList<document>list){
				moduledocument listArct = new moduledocument(list);
				table = new JTable();
				table.setModel(listArct);
				table.addMouseListener(new MouseAdapter(){
					public	void mouseClicked(MouseEvent ev){
						       int index = table.getSelectedRow();
						       s=listArct.getValueAt(index, 2).toString();
						       
						      
					     }
				     });
				table.setFillsViewportHeight(true);
				ouvrir=new JButton("ouvrir");
				chercher =new JLabel("chercher");
				txtmotcle = new JTextField(30);
				this.controleur=controleur;
			  }
			private void dessinner() {
				this.setLayout(new BorderLayout());
				JPanel p1=new JPanel();
				p1.setLayout(new GridLayout(1,1));
				p1.add(chercher);p1.add(txtmotcle);
				this.add(p1,BorderLayout.NORTH);
				this.add(new JScrollPane(table), BorderLayout.CENTER);
				p = new JPanel();
				p.setLayout(new GridLayout(1,1));
				p.add(ouvrir);
				this.add(p,BorderLayout.SOUTH);
				pack();
			}
			private void colsing() {
				this.dispose();
			}
			private void executer1() {
				 ouvrir.addActionListener(
							new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									try {
										controleur.ouvrirdoc(s);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								
								}
								
							});
				 chercher.addMouseListener(
							new MouseAdapter() {
								
							    public void mouseClicked(MouseEvent e) {
							    	try {
										controleur.getdoc(txtmotcle.getText(),id_etape);
									} catch (ClassNotFoundException e1) {
										
										e1.printStackTrace();
									}
							    	
							    }
							    }
			               );
							
							
				 
				 
			}}
		
	 

