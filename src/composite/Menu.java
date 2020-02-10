package composite;

import javax.swing.*;

import setting.SettingPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar{
	private JMenuItem settingItem, undoItem, redoItem, closeItem;
	private JMenu fileMenu;
	private SettingPanel settingPanel;
	
	public Menu() {
		fileMenu = new JMenu("File");
		
		settingItem = new JMenuItem("Setting");
		settingItem.setMnemonic(KeyEvent.VK_S);
		KeyStroke keyStrokeToSetting = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		settingItem.setAccelerator(keyStrokeToSetting);
		settingItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				settingPanel.getInstance();
			}
		});
		
		undoItem = new JMenuItem("Undo");
		undoItem.setMnemonic(KeyEvent.VK_Z);
		KeyStroke keyStrokeToUndo = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
		undoItem.setAccelerator(keyStrokeToUndo);
		
		redoItem = new JMenuItem("Redo");
		redoItem.setMnemonic(KeyEvent.VK_Y);
		KeyStroke keyStrokeToRedo = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
		redoItem.setAccelerator(keyStrokeToRedo);
		
		closeItem = new JMenuItem("Close");
		closeItem.setMnemonic(KeyEvent.VK_X);
		KeyStroke keyStrokeToClose = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
		closeItem.setAccelerator(keyStrokeToClose);
		
		fileMenu.add(settingItem);
		fileMenu.add(undoItem);
		fileMenu.add(redoItem);
		fileMenu.add(closeItem);
		add(fileMenu);
	}

}
