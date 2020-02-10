package task;

import task.state.DisableState;
import task.state.IdleState;
import task.state.WorkState;

import java.util.Objects;
import java.util.Vector;

public class TaskCollection {
    private static TaskCollection instance;
    private Vector<Task> taskList;

    private TaskCollection(){
        taskList = new Vector<>();
    }

    public static TaskCollection getInstance(){
        if(instance==null) instance = new TaskCollection();
        return instance;
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public void removeTask(Task task){
        taskList.remove(task);
    }

    public void disableAllTaskButOne(Task task){
        for(Task innerTask:taskList){
//            if(!task.equals(innerTask)) innerTask.setTaskState(new DisableState());
        }
//        task.setTaskState(new WorkState());
    }

    public void idleAllTask(){
        for(Task innerTask:taskList){
//            innerTask.setTaskState(new IdleState());
        }
    }

    @Override
    public String toString() {
        return "TaskCollection{" +
                "taskCollection=" + taskList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskCollection that = (TaskCollection) o;
        return Objects.equals(taskList, that.taskList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskList);
    }


}
