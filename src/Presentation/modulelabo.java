package Presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import Metier.*;


public class modulelabo extends AbstractTableModel{
   private ArrayList<laboratoire>list;
   
	public modulelabo(ArrayList<laboratoire> list) {
	super();
	this.list = list;
}

	@Override
	public int getRowCount(){
		return this.list.size();
	}

	@Override
	public int getColumnCount() {
		return laboratoire.getAttributs().length;
	}

	@Override
	public Object getValueAt(int i, int j) {
		   return this.list.get(i).get(j);
	}
	@Override
	 public String getColumnName(int i){
		return laboratoire.getAttributs()[i];
	}
	@Override
	public Class getColumnClass(int i) {
		switch (i){
		case 0 : return Integer.class;
		case 1 : return String.class;
		case 2 : return String.class;
		
		}
		return Object.class;
	}
	@Override
	public void setValueAt(Object o, int i,int j){
		switch (j){
		case 2: this.list.get(i).setEmail_labo((String) o);
		case 1: this.list.get(i).setNom_labo((String) o);
		case 0 : this.list.get(i).setId_labo((Integer)o);
		}
	}
}
