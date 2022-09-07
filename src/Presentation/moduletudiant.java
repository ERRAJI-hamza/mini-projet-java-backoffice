package Presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import Metier.*;


public class moduletudiant extends AbstractTableModel{
   private ArrayList<etudiant>list;
   
	public moduletudiant(ArrayList<etudiant> list) {
	super();
	this.list = list;
}

	@Override
	public int getRowCount(){
		return this.list.size();
	}

	@Override
	public int getColumnCount() {
		return etudiant.getAttributs().length;
	}

	@Override
	public Object getValueAt(int i, int j) {
		   return this.list.get(i).get(j);
	}
	@Override
	 public String getColumnName(int i){
		return etudiant.getAttributs()[i];
	}
	@Override
	public Class getColumnClass(int i) {
		switch (i){
		case 0 : return Integer.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4: return String.class;
		case 5 : return String.class;
		case 6 : return String.class;
		}
		return Object.class;
	}
	@Override
	public void setValueAt(Object o, int i,int j){
		switch (j){
		case 0 : this.list.get(i).setId((Integer) o);
		case 1 : this.list.get(i).setName((String) o);
		case 2 : this.list.get(i).setPrenom((String) o);
		case 3 : this.list.get(i).setEmail((String) o);
		case 4 : this.list.get(i).setFiliere((String)o);
		case 5 : this.list.get(i).setNiveau((String)o);
		case 6 : this.list.get(i).setPassword((String)o);
		}
	}
}
