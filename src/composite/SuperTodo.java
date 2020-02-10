package composite;

import javax.swing.*;

import main.Main;
import setting.PointSerializer;
import setting.TaskSerializer;
import task.state.*;

import java.io.Serializable;
import java.util.Vector;

public class SuperTodo implements TodoList, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4067434601041981583L;
	private TaskSerializer taskSerializer = TaskSerializer.getInstance();
	private PointSerializer pointSerializer = PointSerializer.getInstance();
	private String superText;
	private Vector<TodoList> todos;
	private int tier;
	private TodoPanel todoSuper;
	private TaskState myState;
	public SuperTodo(String text, Vector<TodoList>todos, int tier) {
		this.superText = text;
		if(todos.size() == 0) {
			this.todos = new Vector<TodoList>();
		}else {
			this.todos = todos;
		}
		this.tier = tier;
	}
	public int addSubTodo(String text) {
		if(this.tier == 3) {
			todos.add(new Todo(text));
			return 4;
		}else {
			todos.add(new SuperTodo(text, new Vector<TodoList>(), this.tier+1));
			return this.tier+1;
		}
	}
	public TodoPanel getTodoPanel() {
		return this.todoSuper;
	}
	@Override
	public TodoListPanel getTodoList() {
		if(Main.isTaskStarted && this.myState.getClass().getSimpleName().equals("IdleState")) {
			myState = new DisableState(this);
		}else {			
			myState = new IdleState(this);
		}
		TodoListPanel panel = new TodoListPanel();
		todoSuper = new TodoPanel();
		panel.add(todoSuper);
		if(this.tier != 1) {
			todoSuper.setPanel();
			todoSuper.setText(this.superText);
			if(this.myState.getClass().getSimpleName().equals("DisableState")) {
				todoSuper.setPanelDisable();
			}
		}
		for (TodoList todo : todos) {
			TodoListPanel subTodo = todo.getTodoList();
			todo.getTodoPanel().getRemoveButton().addMouseListener(new java.awt.event.MouseAdapter()
		    {					
		        public void mouseReleased(java.awt.event.MouseEvent evt)
		        {
		        	todos.remove(todo);
		        	Main.refresh();
		        }
		    });
			todo.getTodoPanel().getStartButton().addMouseListener(new java.awt.event.MouseAdapter()
		    {					
		        public void mouseReleased(java.awt.event.MouseEvent evt)
		        {
		        	Main.isTaskStarted = true;
		        	todo.setMyState(new WorkState(todo));
		        	Main.refresh();
		        }
		    });
			todo.getTodoPanel().getStopButton().addMouseListener(new java.awt.event.MouseAdapter()
		    {					
		        public void mouseReleased(java.awt.event.MouseEvent evt)
		        {
		    		Main.isTaskStarted = false;
		    		Main.refresh();
		        }
		    });
			todo.getTodoPanel().getDoneButton().addMouseListener(new java.awt.event.MouseAdapter()
		    {					
		        public void mouseReleased(java.awt.event.MouseEvent evt)
		        {
		        	pointSerializer.setPoint(pointSerializer.getPoint()+5);
					pointSerializer.saveData(pointSerializer);
		        	Main.isTaskStarted = false;
		        	todos.remove(todo);
		        	// TODO tambahin point logic ketika DONE button diteken
		        	Main.refresh();
		        }
		    });
			if(this.tier == 2) {					
				subTodo.setBorder(BorderFactory.createEmptyBorder(0,60, 0, 35));
			}
			if(this.tier == 3) {
				subTodo.setBorder(BorderFactory.createEmptyBorder(0,35, 0, 0));
			}
			panel.add(subTodo);
			if(todos.lastElement().equals(todo)) {
				InputTodoPanel input = new InputTodoPanel();
				input.getAddButton().addMouseListener(new java.awt.event.MouseAdapter()
			    {					
			        public void mouseReleased(java.awt.event.MouseEvent evt)
			        {
			        	String text = input.getTextInput();
			        	if(!text.equals("")) {
			        		int tier = addSubTodo(text);
			        		TodoPanel newTodo = new TodoPanel();
			        		newTodo.setPanel();
			        		newTodo.setText(text);
			        		newTodo.getRemoveButton().addMouseListener(new java.awt.event.MouseAdapter()
			    			{					
			    				public void mouseReleased(java.awt.event.MouseEvent evt)
			    				{
			    					System.out.println("oksip");
			    				}
			    			});
			        		subTodo.add(newTodo);
			        		input.clearInput();
			        		Main.refresh();
			        	}
			        	
			        }
			    });
				if(this.tier != 1) {					
					input.setBorder(BorderFactory.createEmptyBorder(0,35, 0, 0));
				}
				if(Main.isTaskStarted) {
					input.setPanelDisable();
				}
				panel.add(input);
			}
				
		}
		if(todos.size()==0) {
			TodoListPanel subTodo = new TodoListPanel();
			if(this.tier == 2) {					
				subTodo.setBorder(BorderFactory.createEmptyBorder(0,60, 0, 35));
			}
			if(this.tier == 3) {
				subTodo.setBorder(BorderFactory.createEmptyBorder(0,35, 0, 0));
			}
			panel.add(subTodo);
			InputTodoPanel input = new InputTodoPanel();
			input.getAddButton().addMouseListener(new java.awt.event.MouseAdapter()
		    {					
		        public void mouseReleased(java.awt.event.MouseEvent evt)
		        {
		        	String text = input.getTextInput();
		        	if(!text.equals("")) {
		        		int tier = addSubTodo(text);
		        		TodoPanel newTodo = new TodoPanel();
		        		newTodo.setPanel();
		        		newTodo.setText(text);
		        		subTodo.add(newTodo);
		        		input.clearInput();
		        		Main.refresh();
		        	}
		        	
		        }
		    });
			if(this.tier != 1) {					
				input.setBorder(BorderFactory.createEmptyBorder(0,35, 0, 0));
			}
			if(Main.isTaskStarted) {
				input.setPanelDisable();
			}
			panel.add(input);
		}
		return panel;
	}
	public Vector<TodoList> getTodos() {
		System.out.println("OBTAINED TASK: "+taskSerializer);
		return taskSerializer.getTodo();
	}
	public void removeTodo(TodoList todo) {
		this.todos.remove(todo);
		Main.refresh();
	}
	@Override
	public TaskState getMyState() {
		return this.myState;
	}
	@Override
	public void setMyState(TaskState myState) {
		this.myState = myState;
	}
	@Override
	public String getNameTodo() {
		String text = this.superText;
		for (TodoList todoList : todos) {
			text += "\n";
			text += "\t" +todoList.getNameTodo();
		}
		return text;
	}
	
}
