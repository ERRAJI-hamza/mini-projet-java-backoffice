package Presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import Metier.*;


public class modeleprofesseur extends AbstractTableModel{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ArrayList<professeur> list;
   
	public modeleprofesseur (ArrayList<professeur> list) {
	super();
	this.list = list;
}

	@Override
	public int getRowCount(){
		return this.list.size();
	}

	@Override
	public int getColumnCount() {
		return professeur.getAttributs().length;
	}

	@Override
	public Object getValueAt(int i, int j) {
		   return this.list.get(i).get(j);
	}
	@Override
	 public String getColumnName(int i){
		return professeur.getAttributs()[i];
	}
	@Override
	public Class getColumnClass(int i) {
		switch (i){
		case 0: return Integer.class;
		case 1: return String.class;
		case 2: return String.class;
		case 3: return String.class;
		case 4: return String.class;
		case 5 : return String.class;
		case 6: return String.class;
		case 7: return String.class;
		case 8: return Integer.class;
		case 9: return String.class;
		}
		return Object.class;
	}
	@Override
	public void setValueAt(Object o, int i,int j){
		switch (j){
		case 0 : this.list.get(i).setId_prof((Integer) o);
		case 1 : this.list.get(i).setNom_prof((String) o);
		case 2 : this.list.get(i).setPrenom_prof((String) o);
		case 3 : this.list.get(i).setGrade((String) o);
		case 4 : this.list.get(i).setEmail_prof((String)o);
		case 7 : this.list.get(i).setId_labo((Integer) o);
		case 6 : this.list.get(i).setNom_filiere((String)o);
		case 5: this.list.get(i).setNom_departement((String)o);
		case 8 : this.list.get(i).setPassword((String)o);
		case 9 : this.list.get(i).setRole((String)o);
		}
	}
}
