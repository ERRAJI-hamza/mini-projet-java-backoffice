package Presentation;

	import java.awt.BorderLayout;
	import java.awt.Container;
	import java.awt.Dimension;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.*;

	import javax.swing.ButtonGroup;
	import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;
	import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import Metier.*;
	import Persistance.*;
public class formsdoc extends JFrame{
	
	
		private JLabel labelid_etape;
		private JLabel labeltype_doc;
		private JLabel labelmot_cle;
		private JTextField textmotcle;
		private JLabel diposer_par_prof;
		private JComboBox jc;
		private JButton parcourir;
		private JFileChooser j;
		private JButton diposer;
		private Integer id_etape;
		private Integer id_projet;
		private JLabel labelnom_doc;
		private JTextField textnom_doc;
		private String dest;
		private Controleur controleur;
			
		 public  formsdoc(Controleur controleur,Integer id_etape ,Integer id_projet){
			    this.id_projet=id_projet;
			    this.id_etape=id_etape;
				this.setTitle("Formulaire");
				this.setSize(500, 500);
				this.initialiser(controleur);
				this.dessinner();
				this.executer();
			}
			
		private void initialiser( Controleur controleur) {
			    labelid_etape = new JLabel("etape "+id_etape);
			    labeltype_doc= new JLabel("type de document");
			    labelmot_cle =new JLabel("mot cle");
			    diposer_par_prof=new JLabel("diposer par professeur");
			    textmotcle=new JTextField(10);
			    jc=new JComboBox();
			    jc.setBounds(10, 10, 10, 10);
			    jc.addItem("document");
			    jc.addItem("livrable");
			    parcourir = new JButton("parcourir");
			    parcourir.setBounds(10, 10, 10, 10);
			    labelnom_doc=new JLabel("nom document");
			    textnom_doc=new JTextField(10);
				diposer = new JButton("diposer");
				this.controleur=controleur;
			}
		private void dessinner() {
				this.setLayout(new BorderLayout());
				JPanel p = new JPanel();
				GridLayout G = new GridLayout(8,1);
				G.setVgap(5);
				p.setLayout(G);
				p.add(labelid_etape);
				p.add(labeltype_doc);
				p.add(jc);
				p.add(parcourir);
				p.add(labelnom_doc);
				p.add(textnom_doc);
				p.add(labelmot_cle);
				p.add(textmotcle);
				this.add(p, BorderLayout.CENTER);
				JPanel p1 = new JPanel();
				p1.setLayout(new GridLayout(1,1));
				p1.add(diposer);
				this.add(p1 , BorderLayout.SOUTH);
				
			}
		private void colsing() {
				this.dispose();
			}
		private void executer() {
				parcourir.addActionListener(
						new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								String com = e.getActionCommand();
								 
						        if (com.equals("parcourir")) {
						            // create an object of JFileChooser class
						            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
						 
						            // invoke the showsSaveDialog function to show the save dialog
						            int r = j.showSaveDialog(null);
						            String src="";
						            if(jc.getSelectedItem()=="document") {
						            dest = "C:\\Users\\user\\Documents\\document_projet";
						            }
						            else if(jc.getSelectedItem()=="livrable")
						            {dest ="C:\\Users\\user\\Documents\\document_livrable";}
						            
						            if (r == JFileChooser.APPROVE_OPTION) {
						            	 src=j.getSelectedFile().getAbsolutePath();
						   
						            	 File srcfile= new File(src);
						            	 File destfile = new File(dest+"/" +srcfile.getName());
						            	      
						                 try {
											Files.copy(srcfile.toPath(), destfile.toPath());
										} catch (Exception e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
						                 textnom_doc.setText(j.getSelectedFile().getAbsolutePath());
						            }
						            // if the user cancelled the operation
						            else
						            	textnom_doc.setText(" ");
						        }
	         
	           	 }
							
						});
				diposer.addActionListener(
						new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								   try {
									controleur.diposerdocument(textnom_doc.getText(),jc.getSelectedItem().toString(),id_etape,id_projet,textmotcle.getText(),diposer_par_prof.getText());
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
				});
				
		
		}}
								
				
		


