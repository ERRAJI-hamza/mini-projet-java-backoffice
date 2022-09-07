package Presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import Metier.*;


public class modulentreprise extends AbstractTableModel{
   private ArrayList<entreprise>list;
   
	public modulentreprise(ArrayList<entreprise> list) {
	super();
	this.list = list;
}

	@Override
	public int getRowCount(){
		return this.list.size();
	}

	@Override
	public int getColumnCount() {
		return entreprise.getAttributs().length;
	}

	@Override
	public Object getValueAt(int i, int j) {
		   return this.list.get(i).get(j);
	}
	@Override
	 public String getColumnName(int i){
		return entreprise.getAttributs()[i];
	}
	@Override
	public Class getColumnClass(int i) {
		switch (i){
		case 0 : return Integer.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		}
		return Object.class;
	}
	@Override
	public void setValueAt(Object o, int i,int j){
		switch (j){
		case 0 : this.list.get(i).setId_Es((Integer)o);;
		case 1 : this.list.get(i).setEmail_ES((String)o);
		case 2 : this.list.get(i).setTele_ES((String)o);
		case 3 : this.list.get(i).setResponsable_Es((String)o);
		}
	}
}
