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

public class frontpedetd extends JFrame{
	
		private ArrayList<etape>list;
	    private JTable table;
	    private JButton idprojet;
	    private JButton consulter_document;
        private JButton diposer_document;
        private Controleur controleur;
        private JPanel p;
        private Object source;
        private Integer id_projet;
        private Integer id_etape;
        
		  public frontpedetd(Controleur controleur ,ArrayList<etape>list,Integer id_projet) throws HeadlessException {
				super();  
				this.id_projet=id_projet;
				this.setSize(500, 300);
				setVisible(true);
				this.list = list;
				this.initialiser(controleur , list );
				this.dessinner();
				this.executer1();
				this.executer2();
			}
			private void initialiser(Controleur controleur , ArrayList<etape>list){
				moduletape listArct = new moduletape(list);
				table = new JTable();
				table.setModel(listArct);
				table.addMouseListener(new MouseAdapter(){
					public	void mouseClicked(MouseEvent ev){
						       int index = table.getSelectedRow();
						       id_etape= Integer.parseInt(listArct.getValueAt(index, 0).toString());
					     }
				     });
				table.setFillsViewportHeight(true);
				consulter_document=new JButton("consulter document");
				diposer_document=new JButton("diposer document");
				this.controleur=controleur;
			  }
			private void dessinner() {
				this.setLayout(new BorderLayout());
				this.add(new JScrollPane(table), BorderLayout.NORTH);
				p = new JPanel();
				p.setLayout(new GridLayout(1,2));
				p.add(consulter_document);
				p.add(diposer_document);
				this.add(p,BorderLayout.SOUTH);
				pack();
			}
			private void colsing() {
				this.dispose();
			}
			private void executer1() {
				consulter_document.addActionListener(
							new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
								    try {
										controleur.opendoc(id_etape);
									} catch (ClassNotFoundException e1) {
										e1.printStackTrace();
									}
									colsing();	
								}
								
							});
			}
			private void executer2(){
				 diposer_document.addActionListener(
							new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									controleur.diposerdocetd(id_etape,id_projet);
									colsing();						
								}
								
							});
			}
		
	          
	}

