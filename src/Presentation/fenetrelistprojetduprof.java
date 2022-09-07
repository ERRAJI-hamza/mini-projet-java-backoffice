package Presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Metier.etape;

public class fenetrelistprojetduprof extends JFrame{
      private JButton idprojet;
      private Controleur controleur;
      private JPanel p ;
	 public fenetrelistprojetduprof(Controleur controleur,ArrayList<Integer>listidprj) throws HeadlessException{
		super();  
		this.setSize(600, 600);
		this.initialiser(controleur  ,listidprj);
		this.dessinner();
		
		
	}
	private void initialiser(Controleur controleur , ArrayList<Integer>listidprj){
		p = new JPanel();
		p.setLayout(new GridLayout(listidprj.size(),2));
		for	(int	i=0	;	i<listidprj.size()	;	i++){	
			idprojet	=	new	JButton	("projet "+listidprj.get(i))	;
			idprojet.addMouseListener((MouseListener) new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
                    try {
						exucte(e.getSource());
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}});
			p.add(idprojet);
			}
		this.controleur=controleur;
	  }
	private void dessinner() {
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
		pack();
	}
	private void colsing() {
		this.dispose();
	}
	
	     public void exucte(Object	e) throws ClassNotFoundException {
	    	 Object	source	=	e	;
	    	 if	(source	instanceof	JButton	){	
	    		 JButton	bSource	=	(JButton)	source	;
                 String s=bSource.getText();
                 s=s.substring(7);
                 controleur.fntetape(Integer.parseInt(s));
		         }
	}
	
}
