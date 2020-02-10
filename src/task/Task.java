package task;

import task.state.IdleState;
import task.state.TaskState;

import java.util.Objects;
import java.util.Vector;

public class Task implements TaskComponent{

    private int level=0;
    private Vector<TaskComponent> taskChildren = new Vector<TaskComponent>();
    private String taskName;
    private TaskState taskState;
    private TaskCollection taskCollection = TaskCollection.getInstance();

    public Task(String taskName) {
        this.taskName = taskName;
//        this.taskState = new IdleState(this);
    }

    @Override
    public void add(TaskComponent taskComponent) {
        if(this.level!=2) {
            taskChildren.add(taskComponent);
            taskComponent.setLevel(this.level+1);
        }
    }

    public void addTaskToCollection(){
        taskCollection.addTask(this);
    }

    @Override
    public void start() {
        //jalankan timer
        taskCollection.disableAllTaskButOne(this);
    }

    @Override
    public void done() {
        //jalankan timer
        for(TaskComponent task:taskChildren){
            for(TaskComponent tasks:task.getTaskChildren()){
                taskCollection.removeTask((Task)tasks);
            }
            task.getTaskChildren().clear();
            taskCollection.removeTask((Task)task);
        }
        taskCollection.removeTask(this);
        taskCollection.idleAllTask();
    }

    @Override
    public void remove() {
        for(TaskComponent task:taskChildren){
            for(TaskComponent tasks:task.getTaskChildren()){
                taskCollection.removeTask((Task)tasks);
            }
            task.getTaskChildren().clear();
            taskCollection.removeTask((Task)task);
        }
        taskCollection.removeTask(this);
        taskCollection.idleAllTask();
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
                "level=" + level +
                ", taskName='" + taskName + '\'' +
                ", taskState=" + taskState +
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

    public void setTaskState(TaskState taskState){
        this.taskState = taskState;
    }

    public TaskState getTaskState(){
        return this.taskState;
    }

    public Vector<TaskComponent> getTaskChildren() {
        return taskChildren;
    }

    public void setTaskChildren(Vector<TaskComponent> taskChildren) {
        this.taskChildren = taskChildren;
    }

    public TaskCollection getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(TaskCollection taskCollection) {
        this.taskCollection = taskCollection;
    }
}
