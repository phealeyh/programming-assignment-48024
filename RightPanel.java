import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import java.awt.*;
import java.awt.image.ColorModel;
import java.util.LinkedList;

import model.*;

public class RightPanel extends JPanel implements View{
	/* Private Instance Variables -- The updated window with the text field*/
	private GridLayout grid;
	private DefaultListModel model = new DefaultListModel();
	private JList list;
	private Tower tower;
	private RoomWindow roomWindow;
	
	//holds the list of apartments

	public RightPanel(Tower tower){
		this.tower = tower;
		setup(); //setup the layout/structure of window
		build();
		tower.attachPanel(this);
	}

	private void setup(){
		setBorder(BorderFactory.createLineBorder(Color.blue));
		setPreferredSize(new Dimension(200, 200));
		setBackground(Color.white);
		setLayout(grid = new GridLayout());
	}

	private void build(){
		add(list = new JList(model));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListListener());
	}

	public void addStudent(String name){
		tower.add(new Student(name));
	}

	public void moveStudent(String name){
		tower.move(name);
	}

	public void update(){ //updates main panel jList
		model.clear();
		LinkedList<String> used = tower.used();
		for(String apartment: used){ 
			model.addElement(apartment);
		}
	}


	private class ListListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e){
			//check the position of the list
			if(e.getValueIsAdjusting())
				return;
			int index = list.getSelectedIndex();
			if(index == -1) //means a value has been clicked
				return;
			int apt_id = Integer.parseInt((String) model.get(index));
			new RoomWindow(tower,tower.apt(apt_id));
		}
	}	


}
