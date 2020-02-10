package task.state;

import composite.TodoList;

public abstract class TaskState {
	protected TodoList todoList;
	public TaskState(TodoList todoList) {
		this.todoList = todoList;
	}
}
