package Presentation;

	import java.util.ArrayList;

	import javax.swing.table.AbstractTableModel;
	import Metier.*;

public class modelerv extends AbstractTableModel {
	
	   private ArrayList<rendez>list;
	   
		public modelerv(ArrayList<rendez> list) {
		super();
		this.list = list;
	}

		@Override
		public int getRowCount(){
			return this.list.size();
		}

		@Override
		public int getColumnCount() {
			return rendez.getAttributs().length;
		}

		@Override
		public Object getValueAt(int i, int j) {
			   return this.list.get(i).get(j);
		}
		@Override
		 public String getColumnName(int i){
			return rendez.getAttributs()[i];
		}
		@Override
		public Class getColumnClass(int i) {
			switch (i){
			case 0 : return Integer.class;
			case 1 : return Integer.class;
			case 2 : return Integer.class;
			case 3 : return String.class;
			case 4 : return String.class;
			}
			return Object.class;
		}
		@Override
		public void setValueAt(Object o, int i,int j){
			switch (j){
			case 0 : this.list.get(i).setId_rv((Integer)o);
			case 1 : this.list.get(i).setId_prof((Integer)o);
			case 2 : this.list.get(i).setId((Integer)o);
			case 3 : this.list.get(i).setDate((String)o);
			case 4 : this.list.get(i).setHeur((String)o);
			}
		}
	}

