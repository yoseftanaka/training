package composite;

import javax.swing.*;
import java.awt.*;

public class InputTodoPanel extends JPanel {
	private JTextField textInput;
	private JButton addButton;
	private JPanel buttonPanel;
	
	public JButton getAddButton() {
		return this.addButton;
	}
	public void clearInput() {
		this.textInput.setText("");
	}
	public String getTextInput() {
		return textInput.getText();
	}
	
	public InputTodoPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setMaximumSize(new Dimension(600,50));
		setMinimumSize(new Dimension(300,50));
		textInput = new JTextField();
		textInput.setPreferredSize(new Dimension(200, 30));
		textInput.setMaximumSize(new Dimension(200,30));
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		addButton = new JButton("Add");
		buttonPanel.add(addButton);
		add(textInput);
		add(buttonPanel);
	}
	public void setPanelDisable() {
		textInput.disable();
		addButton.setEnabled(false);
	}
//	protected void do_btnRefresh_actionPerformed() {
//		JFrame frame1 = (JFrame) SwingUtilities.getWindowAncestor(this);
//		System.out.println(frame1);
//	    SwingUtilities.updateComponentTreeUI(frame1);
//	    frame1.invalidate();
//	    frame1.validate();
//	    frame1.repaint();
//	}
}