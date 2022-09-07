package Presentation;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Metier.*;

public class moduledocument extends AbstractTableModel{
	
	   private ArrayList<document>list;
	   
		public moduledocument(ArrayList<document> list) {
		super();
		this.list = list;
	}

		@Override
		public int getRowCount(){
			return this.list.size();
		}

		@Override
		public int getColumnCount() {
			return document.getAttributs().length;
		}

		@Override
		public Object getValueAt(int i, int j) {
			   return this.list.get(i).get(j);
		}
		@Override
		 public String getColumnName(int i){
			return document.getAttributs()[i];
		}
		@Override
		public Class getColumnClass(int i) {
			switch (i){
			case 0 : return Integer.class;
			case 1 : return String.class;
			case 2 : return String.class;
			case 3 : return Integer.class;
			case 4 : return String.class;
			case 5 : return String.class;
			}
			return Object.class;
		}
		@Override
		public void setValueAt(Object o, int i,int j){
			switch (j){
			case 0 : this.list.get(i).setId_doc((Integer)o);
			case 1 : this.list.get(i).setType_doc((String) o);
			case 2 : this.list.get(i).setNom_doc((String) o);
			case 3 : this.list.get(i).setId_etape((Integer)o);
			case 5 : this.list.get(i).setMot_cle((String) o);
			case 6 : this.list.get(i).setDiposer((String) o);
			}
		}
	}


