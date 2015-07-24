import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;

import model.*;

import java.util.LinkedList;

public class RoomWindow extends JFrame{
	/* Private Instance Variables */
	private Apt apt;
	private Tower tower;
	private JPanel panel;

	

	public RoomWindow(Tower tower, Apt apt){
		this.tower = tower;
		this.apt = apt;
		setup();
		build();
		pack();
		setVisible(true);
	}
	
	private void setup(){
		setLocation(900,500);
		setPreferredSize(new Dimension(250,100));
		setTitle("Apartment " + apt.id());
	}


	
	private void build(){
		add(new RoomPanel(tower, apt));
	}
	
}