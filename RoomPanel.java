import java.awt.Color;
import java.util.LinkedList;
import model.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.*;

public class RoomPanel extends JPanel implements View{ //creates the room's actual panel
	
	private RoomTable room; //actual model
	private JTable tableData; //table
	private Tower tower;
	private Apt apt;
	
	public RoomPanel(Tower tower, Apt apt){
		this.apt = apt;
		this.tower = tower;
		setup();
		build();
		tower.attachPanel(this);
	}
		
	private void setup(){
		setBorder(BorderFactory.createLineBorder(Color.green));
	}
		
	private void build(){
		room = new RoomTable();
		fillTable(); //fill in table with proper data
		tableData = new JTable(room);
		tableData.setSize(250,50);
		JTableHeader header = tableData.getTableHeader();
		header.setSize(250, 50);
		add(header);
		add(tableData);
	}
	
	public void update(){
		//get the apt id
		apt = tower.apt(apt.id());
		fillTable();
		room.fireTableDataChanged();
	}


	private void fillTable(){
		LinkedList<Room> rooms = apt.rooms();
		int bedIndex = 0;
		for(Room bed: rooms){
			Student student = bed.student();
			if(bed.isUsed()){
				room.setValueAt(student.name(),bedIndex,1);
			}
			else{
				room.setValueAt(null, bedIndex, 1);
			}
			bedIndex++;
		}
	}
	


	private class RoomTable extends AbstractTableModel{
		private final int ROWS;
		private final int COLS = 2;
		private final String[] headers = {"Bed", "Student"};
		private String[][] data;

		public RoomTable(){
			//get amount of students
			ROWS = apt.size();
			data = new String[ROWS][COLS];
			setBeds();
		}
		
		
		public void setBeds(){
			for(int i = 0; i < ROWS; i++ ){
				int bedNumber = i + 1;
				data[i][0] = Integer.toString(bedNumber);
			}
		}

		public String getColumnName(int col){ 
			return headers[col]; 
		}

		public int getRowCount(){
			return ROWS;
		}

		public int getColumnCount(){
			return headers.length;
		}


		public String getValueAt(int row, int col) {
			return data[row][col]; 
		}

		public void setValueAt(String newValue, int row, int col){
			data[row][col] = newValue;
	    }
				
	} //end private class

}
