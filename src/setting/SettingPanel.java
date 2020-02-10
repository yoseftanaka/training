package setting;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class SettingPanel extends JFrame implements ActionListener{
	
	private static SettingPanel settingPanel;
	private ConfigSerializer configSer = ConfigSerializer.getInstance();
	private PointSerializer pointSer = PointSerializer.getInstance();
	private JLabel workMinuteLabel, workSecondLabel;
	private JLabel restMinuteLabel, restSecondLabel;
	private JSpinner workMinuteSpinner, workSecondSpinner;
	private JSpinner restMinuteSpinner, restSecondSpinner;
	private JButton saveButton;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private SettingPanel() {
		init();
		System.out.println("got: "+configSer);
		
		setLayout(new GridBagLayout());
		gbc.gridx=0;
		gbc.gridy=0;
		addRowComponent(workMinuteLabel, workMinuteSpinner, 0);
		addRowComponent(workSecondLabel, workSecondSpinner, 1);
		addRowComponent(restMinuteLabel, restMinuteSpinner, 2);
		addRowComponent(restSecondLabel, restSecondSpinner, 3);
		gbc.gridy++;
		add(saveButton,gbc);
		saveButton.addActionListener(this);
	};
	
	private void init() {
		setSize(400,400);
		setVisible(true);
		workMinuteLabel = new JLabel("Work Minute");
		workSecondLabel = new JLabel("Work Second");
		restMinuteLabel = new JLabel("Rest Minute");
		restSecondLabel = new JLabel("Rest Second");
		saveButton = new JButton("Save");
		workMinuteSpinner = new JSpinner();
		workMinuteSpinner.setValue(configSer.getWorkMinute());
		workSecondSpinner = new JSpinner();
		workSecondSpinner.setValue(configSer.getWorkSecond());
		restMinuteSpinner = new JSpinner();
		restMinuteSpinner.setValue(configSer.getRestMinute());
		restSecondSpinner = new JSpinner();
		restSecondSpinner.setValue(configSer.getRestSecond());
	}
	
	private void addRowComponent(JLabel componentLabel, JSpinner componentSpinner, int y_position) {
		gbc.gridy = y_position;
		add(componentLabel,gbc);
		gbc.gridx++;
		add(componentSpinner,gbc);
		gbc.gridx--;
	}
	
	public static SettingPanel getInstance() {
		if(settingPanel==null) settingPanel = new SettingPanel();
		return settingPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("test "+workMinuteSpinner.getValue());
		
		configSer.setWorkMinute((int)workMinuteSpinner.getValue());
		configSer.setWorkSecond((int)workSecondSpinner.getValue());
		configSer.setRestMinute((int)restMinuteSpinner.getValue());
		configSer.setRestSecond((int)restSecondSpinner.getValue());
		configSer.saveData(configSer);
	}
	
	
}
