import task.Task;
import task.TaskCollection;
import task.TaskComponent;

public class Main {

    public static void main(String[] args) {
        TaskCollection a = TaskCollection.getInstance();
        TaskComponent task1 = new Task("ABC");
        task1.addTaskToCollection();
        TaskComponent task2 = new Task("abc");
        task2.addTaskToCollection();
        TaskComponent task3 = new Task("DEF");
        task3.addTaskToCollection();
        task1.add(task2);
        task1.start();
        System.out.println(a.toString());
        System.out.println(task1.toString());
        System.out.println(task2.toString());
        System.out.println(task3.toString());
        System.out.println(task1.getTaskChildren().toString());
        task1.remove();
//        TaskCollection a = TaskCollection.getInstance();
        System.out.println(a.toString());

    }
}
