package task;

public interface TaskComponent {
    public void add(TaskComponent taskComponent);
    public void start(TaskComponent taskComponent);
    public void done(TaskComponent taskComponent);
    public void remove(TaskComponent taskComponent);
    public void setLevel(int level);
    public int getLevel();
    public void setTaskName(String taskName);
    public String getTaskName();
}
