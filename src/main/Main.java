package main;

import javax.swing.*;

import composite.SuperTodo;
import composite.TodoList;
import composite.Menu;
import setting.PointSerializer;
import setting.TaskSerializer;

import java.awt.*;
import java.util.Vector;

public class Main {
	
	static JFrame pomotodoFrame;
	static JScrollPane scrollPane;
	static SuperTodo main;
	public static boolean isTaskStarted = false;
	static PointSerializer pointSerializer= PointSerializer.getInstance();
	public Main() {
		init();
	}
	public static void main(String[] args) {
		new Main();
	}
	
	public void init() {
		// Data Dummy	
		SuperTodo tidur = new SuperTodo("Tidur", new Vector<TodoList>(), 3);
		tidur.addSubTodo("Cuci Muka");
		tidur.addSubTodo("Berdoa");
		SuperTodo makanMalam = new SuperTodo("Makan malam", new Vector<TodoList>(), 3);
		makanMalam.addSubTodo("Ambil nasi");
		makanMalam.addSubTodo("Ambil lauk");
		makanMalam.addSubTodo("Minum air");
		
		Vector<TodoList> vectorMalam = new Vector<TodoList>();
		vectorMalam.add(tidur);
		vectorMalam.add(makanMalam);
		
		SuperTodo kegiatanMalam = new SuperTodo("Kegiatan Malam", vectorMalam, 2);
		
		SuperTodo kerja = new SuperTodo("Kerja", new Vector<TodoList>(), 3);
		kerja.addSubTodo("Susun jadwal");
		kerja.addSubTodo("Rapat");
		kerja.addSubTodo("Diskusi");
		SuperTodo makanSiang = new SuperTodo("Makan siang", new Vector<TodoList>(), 3);
		makanSiang.addSubTodo("Ambil nasi kuning");
		makanSiang.addSubTodo("Ambil lauk tempe");
		makanSiang.addSubTodo("Minum air teh");
		
		Vector<TodoList> vectorSiang = new Vector<TodoList>();
		vectorSiang.add(kerja);
		vectorSiang.add(makanSiang);
		
		SuperTodo kegiatanSiang = new SuperTodo("Kegiatan Siang", vectorSiang, 2);
		
		Vector<TodoList> kegiatan = new Vector<TodoList>();
		kegiatan.add(kegiatanSiang);
		kegiatan.add(kegiatanMalam);
		
		main = new SuperTodo("Main", kegiatan, 1);
		// End Data Dummy
		pomotodoFrame = new JFrame("Point: "+ pointSerializer.getPoint());
		scrollPane = new JScrollPane(main.getTodoList());
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		pomotodoFrame.setResizable(false);
		pomotodoFrame.setSize(700, 600);
		pomotodoFrame.setContentPane(scrollPane);
		pomotodoFrame.setLayout(new ScrollPaneLayout());
		pomotodoFrame.setLocationRelativeTo(null);
		pomotodoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pomotodoFrame.setJMenuBar(new Menu());
		pomotodoFrame.setVisible(true);		
	}
	public static void refresh() {
		pomotodoFrame.setTitle("Point: "+ pointSerializer.getPoint());
		System.out.println("+++++++++++++++++");
		Vector<TodoList> todos = main.getTodos();
		System.out.println(todos);
		
		// TODO ini vector diatas udh berisi semua data 
		// nanti pas refresh tinggal masukin data dari .ser ke vector lalu masukin ke main dengan cara 
		// main = new SuperTodo("Main", vectornya, 1);
		// ganti data dummy diatas dengan data dari .ser yang task
		for (TodoList todoList : todos) {
			System.out.println(todoList.getNameTodo());
		}
		scrollPane = new JScrollPane(main.getTodoList());
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pomotodoFrame.setResizable(false);
		pomotodoFrame.setSize(700, 600);
		pomotodoFrame.setContentPane(scrollPane);
		pomotodoFrame.setLayout(new ScrollPaneLayout());
		pomotodoFrame.setLocationRelativeTo(null);
		pomotodoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pomotodoFrame.setJMenuBar(new Menu());
		pomotodoFrame.setVisible(true);		
	}
}
