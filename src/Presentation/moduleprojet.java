package Presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import Metier.*;


public class moduleprojet extends AbstractTableModel{
   private ArrayList<projet>list;
   
	public moduleprojet(ArrayList<projet> list) {
	super();
	this.list = list;
}

	@Override
	public int getRowCount(){
		return this.list.size();
	}

	@Override
	public int getColumnCount() {
		return projet.getAttributs().length;
	}

	@Override
	public Object getValueAt(int i, int j) {
		   return this.list.get(i).get(j);
	}
	@Override
	 public String getColumnName(int i){
		return projet.getAttributs()[i];
	}
	@Override
	public Class getColumnClass(int i) {
		switch (i){
		case 0 : return Integer.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4: return String.class;
		case 5 : return Integer.class;
		case 6 : return Integer.class;
		case 7: return Integer.class;
		case 8 : return Integer.class;
		case 9 : return Integer.class;
		}
		return Object.class;
	}
	@Override
	public void setValueAt(Object o, int i,int j){
		switch (j){
		case 0 : this.list.get(i).setId_projet((Integer)o);
		case 1 : this.list.get(i).setTitre((String)o);
		case 2 : this.list.get(i).setDate_debut((String)o);
		case 3 : this.list.get(i).setDuree((String)o);
		case 4 : this.list.get(i).setType((String)o);
		case 5 : this.list.get(i).setId((Integer)o);
		case 6 : this.list.get(i).setId_prof((Integer)o);
		case 7 : this.list.get(i).setId_labo((Integer)o);
		case 8 : this.list.get(i).setId_Es((Integer)o);
		case 9 : this.list.get(i).setEncadrant_2((Integer)o);;
		}
	}
}

