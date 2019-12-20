import task.Task;
import task.TaskComponent;

public class Main {

    public static void main(String[] args) {
        TaskComponent task1 = new Task("ABC");
        TaskComponent task2 = new Task("abc");
        task1.add(task2);
        System.out.println(task1.getLevel());
        System.out.println(task2.getLevel());
    }
}
