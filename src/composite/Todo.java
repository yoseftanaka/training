package composite;

import main.Main;
import task.state.*;

public class Todo implements TodoList {
	private String text;
	private TodoPanel todo;
	private TaskState myState;
	public Todo(String text) {
		this.text = text;
	}
	
	@Override
	public TodoListPanel getTodoList() {
		if(Main.isTaskStarted && this.myState.getClass().getSimpleName().equals("IdleState")) {
			myState = new DisableState(this);
		}else {			
			myState = new IdleState(this);
		}
		TodoListPanel panel = new TodoListPanel();
		todo = new TodoPanel();
		todo.setPanel();
		todo.setText(this.text);
		if(myState.getClass().getSimpleName().equals("DisableState")) {
			todo.setPanelDisable();
		}
		panel.add(todo);
		return panel;
	}

	@Override
	public TodoPanel getTodoPanel() {
		// TODO Auto-generated method stub
		return this.todo;
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
		return "\t"+this.text;
	}
}

