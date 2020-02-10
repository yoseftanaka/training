package composite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TodoPanel extends JPanel {
	private JTextField textInput;
	private JButton addButton, startButton, doneButton, removeButton, stopButton;
	private JPanel buttonPanel;
	private JLabel timerLabel;
	private boolean isClick = false;
	public TodoPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setMaximumSize(new Dimension(600,50));
		setMinimumSize(new Dimension(300,50));
	}
	
	public void setPanel() {
		textInput = new JTextField();
		textInput.disable();
		textInput.setPreferredSize(new Dimension(200, 30));
		textInput.setMaximumSize(new Dimension(200,30));
		textInput.setMinimumSize(new Dimension(200,30));
		timerLabel = new JLabel();
		timerLabel.setText("");
		timerLabel.setForeground(Color.RED);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		stopButton.setVisible(isClick);
		startButton.setVisible(!isClick);
		doneButton = new JButton("Done");
		removeButton = new JButton("Remove");
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(doneButton);
		buttonPanel.add(removeButton);
		add(textInput);
		add(timerLabel);
		add(buttonPanel);
	}
	public void setPanelDisable() {
		startButton.setEnabled(false);
		doneButton.setEnabled(false);
		removeButton.setEnabled(false);
	}
	public JButton getStartButton() {
		return this.startButton;
	}
	public JButton getStopButton() {
		return this.stopButton;
	}
	public JButton getRemoveButton() {
		return this.removeButton;
	}
	public JButton getDoneButton() {
		return this.doneButton;
	}
	public void startClicked() {
		startButton.setVisible(false);
		stopButton.setVisible(true);
	}
	public void interruptTimer() {
		setTimerLabel("");
		setTimerColor(Color.RED);
		startButton.setVisible(true);
		stopButton.setVisible(false);
	}
	public void setText(String text) {
		textInput.setText(text);
	}
	public void setTimerColor(Color color) {
		this.timerLabel.setForeground(color);
	}
	public void setTimerLabel(String time) {
		this.timerLabel.setText(time);
		startClicked();
	}
}