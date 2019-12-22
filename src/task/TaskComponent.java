package task;

import java.util.Vector;

public interface TaskComponent {
    public void add(TaskComponent taskComponent);
    public void start();
    public void done();
    public void remove();
    public void setLevel(int level);
    public int getLevel();
    public void setTaskName(String taskName);
    public String getTaskName();
    public void addTaskToCollection();
    public Vector<TaskComponent> getTaskChildren();
}
