import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel{
	/* Private Instance Variables - Buttons and text fields*/
	private JLabel studentLabel;
	private JTextField studentName;
	private JButton addButton;
	private JButton moveButton;
	private BorderLayout borderLayout;
	private RightPanel rightPanel;

	public LeftPanel(RightPanel rightPanel){
		this.rightPanel = rightPanel;
		setup();
		build();
	}
	private void setup(){
		setLayout(borderLayout = new BorderLayout());
	}

	private void build(){
        ButtonListener listener = new ButtonListener();
        Box vBox = Box.createVerticalBox();
        vBox.add(studentLabel = new JLabel("Student"));
        studentLabel.setLocation(200, 200);
        vBox.add(studentName = new JTextField());
		Box hBox = Box.createHorizontalBox();
		hBox.add(addButton = button("Add", listener));
		hBox.add(moveButton = button("Move", listener));
		add(vBox,BorderLayout.NORTH);
		add(hBox,BorderLayout.SOUTH);
	}

	private JButton button(String label, ButtonListener listener){
		JButton button = new JButton(label);
		button.addActionListener(listener);
		return button;
	}

	public String getName(){
		return studentName.getText();
	}

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Object source = event.getActionCommand(); //gets the name of the button
            //get string name entered
            String name = studentName.getText();
            if(source.equals("Add")){
            	//add the student to a room
         		studentName.setText("");
            	rightPanel.addStudent(name);
            }
            else{ //move is selected
            	rightPanel.moveStudent(name);
            }
            
            rightPanel.update();
        }
    }


}
