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

public class fenetreprojet extends JFrame{
		      private ArrayList<projet>list;
	          private JTable table;
	          private JButton creation;
	          private JButton modification;
	          private JButton edition;
	          private Controleur controleur;
	          private JPanel p;
	          private Object source;
	          private projet prj;
			public fenetreprojet(Controleur controleur ,ArrayList<projet>list) throws HeadlessException {
				super();  
				this.setSize(500, 300);
				setVisible(true);
				this.list = list;
				this.initialiser(controleur , list);
				this.dessinner();
				this.executer1();
				this.executer2();
			}
			private void initialiser(Controleur controleur , ArrayList<projet>list){
				moduleprojet listArct = new moduleprojet(list);
				table = new JTable(listArct);
				table.addMouseListener(new MouseAdapter(){
					public	void mouseClicked(MouseEvent ev){
						       int index = table.getSelectedRow();
						       Integer pidprojet= Integer.parseInt(listArct.getValueAt(index, 0).toString());
						       String ptitre= listArct.getValueAt(index, 1).toString();
						       String pdate_dube= listArct.getValueAt(index, 2).toString();
						       String pduree= listArct.getValueAt(index, 3).toString();
						       String ptype= listArct.getValueAt(index, 4).toString();
						       Integer pid= Integer.parseInt(listArct.getValueAt(index, 5).toString());
						       Integer pid_prof= Integer.parseInt(listArct.getValueAt(index, 6).toString());
						       Integer pidlabo= Integer.parseInt(listArct.getValueAt(index, 7).toString());
						       Integer pid_Es=Integer.parseInt(listArct.getValueAt(index, 8).toString());
						       Integer pid_prof2= Integer.parseInt(listArct.getValueAt(index, 9).toString());
						       prj=new projet(pidprojet,ptitre,pdate_dube,pduree,ptype,pid,pid_prof,pidlabo,pid_Es,pid_prof2);
					     }
				     });
				table.setFillsViewportHeight(true);
				creation = new JButton("creation");
				modification= new JButton("modification");
				edition= new JButton("edition");
				p = new JPanel();
				this.controleur=controleur;
			  }
			private void dessinner() {
				this.setLayout(new BorderLayout());
				this.add(new JScrollPane(table), BorderLayout.NORTH);
				p.setLayout(new GridLayout(1,4));
				p.add(creation);
				p.add(modification);
				p.add(edition);
				this.add(p,BorderLayout.SOUTH);
				pack();
			}
			private void colsing() {
				this.dispose();
			}
			private void executer1() {
				 creation.addActionListener(
							new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									controleur.affiprj();
									colsing();
									
								}
								
							});
			}
			private void executer2(){
				 modification.addActionListener(
							new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									try {
										
										controleur.formodifier(prj);
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									colsing();
									
								}
								
							});
			}
		
	          
	}


	
	

