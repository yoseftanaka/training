package composite;
import task.state.TaskState;

public interface TodoList {
	public TodoListPanel getTodoList();
	public TodoPanel getTodoPanel();
	public void setMyState(TaskState myState);
	public TaskState getMyState();
	public String getNameTodo();
}
