package setting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Vector;

import composite.TodoList;

public class TaskSerializer extends SerializerTemplate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6177302580293436157L;
	private static TaskSerializer taskSerializer;
	private Vector<TodoList> todo;
	
	private TaskSerializer() {
		obtainData();
	}
	
	public static TaskSerializer getInstance() {
		if(taskSerializer==null) taskSerializer = new TaskSerializer();
		System.out.println("PASSED TASK: "+taskSerializer);
		return taskSerializer;
	}

	public Vector<TodoList> getTodo() {
		return todo;
	}

	public void setTodo(Vector<TodoList> todo) {
		this.todo = todo;
	}

	@Override
	protected void setFileoutTarget() throws Exception {
		// TODO Auto-generated method stub
		this.fileout = new FileOutputStream("task.ser",false);
	}

	@Override
	protected void setFileinTarget() throws Exception {
		// TODO Auto-generated method stub
		this.filein = new FileInputStream("task.ser");
	}

	@Override
	protected void readFromFile() throws Exception {
		// TODO Auto-generated method stub
		taskSerializer = (TaskSerializer) this.objectInputStream.readObject();
	}
	
	
}
