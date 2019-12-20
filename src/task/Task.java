package task;

import java.util.Objects;
import java.util.Vector;

public class Task implements TaskComponent {

    private int level=0;
    private Vector<TaskComponent> taskChildren = new Vector<TaskComponent>();
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void add(TaskComponent taskComponent) {
        if(this.level!=2) taskChildren.add(taskComponent);
        taskComponent.setLevel(this.level+1);
    }

    @Override
    public void start(TaskComponent taskComponent) {
        //jalankan timer
    }

    @Override
    public void done(TaskComponent taskComponent) {
        //jalankan timer
        taskChildren.remove(taskComponent);
    }

    @Override
    public void remove(TaskComponent taskComponent) {
        taskChildren.remove(taskComponent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return level == task.level &&
                Objects.equals(taskChildren, task.taskChildren) &&
                Objects.equals(taskName, task.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, taskChildren, taskName);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                '}';
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
