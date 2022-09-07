package Presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import Metier.*;


public class moduledepartement extends AbstractTableModel{
   private ArrayList<departement>list;
   
	public moduledepartement(ArrayList<departement> list) {
	super();
	this.list = list;
}

	@Override
	public int getRowCount(){
		return this.list.size();
	}

	@Override
	public int getColumnCount() {
		return departement.getAttributs().length;
	}

	@Override
	public Object getValueAt(int i, int j) {
		   return this.list.get(i).get(j);
	}
	@Override
	 public String getColumnName(int i){
		return departement.getAttributs()[i];
	}
	@Override
	public Class getColumnClass(int i) {
		switch (i){
		case 0 : return String.class;
		case 1 : return String.class;
		
		}
		return Object.class;
	}
	@Override
	public void setValueAt(Object o, int i,int j){
		switch (j){
		case 1: this.list.get(i).setEmail_departement((String) o);;
		case 0 : this.list.get(i).setNom_departement((String) o);
		}
	}
}
