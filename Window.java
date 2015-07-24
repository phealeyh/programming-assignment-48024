import java.awt.*;

import javax.swing.*;

import model.Tower;

public class Window extends JFrame{
	
	private Tower tower;
	
	public Window(Tower tower){
		this.tower = tower;
		setup(); //set the location of the window
		build(); //add the panel to the window
		pack();
		setVisible(true);
	}

	private void setup(){
		setLocation(500,500); //set the location of the window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void build(){
		add(new Panel());
	}
private class Panel extends JPanel
	/* Controls the two other panels */
	{   public Panel()
	    {   setup();
	        build();    }

	    private void setup()
	    {   
	        setBorder(BorderFactory.createLineBorder(Color.blue)); //window border
	    }
	        
	    private void build()
	    { 
	    	RightPanel rightPanel = new RightPanel(tower);
	        LeftPanel leftPanel = new LeftPanel(rightPanel);
	        add(leftPanel);
	        add(rightPanel);
	    }
	}


}
