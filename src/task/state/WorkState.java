package task.state;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import composite.TodoList;
import main.Main;
import setting.ConfigSerializer;

public class WorkState extends TaskState {
	private Timer timer;
	private ConfigSerializer configSerializer = ConfigSerializer.getInstance();
	private int time = configSerializer.getWorkMinute()*60+configSerializer.getWorkSecond();
	public WorkState(TodoList todoList) {
		super(todoList);
    	working();
	}
	public void working() {
		timer = new Timer();
		class TimerTasks extends TimerTask {
			public void run() {
				int tick = time+1;
				if(!Main.isTaskStarted) {
					todoList.getTodoPanel().interruptTimer();
					timer.cancel();
					todoList.setMyState(new IdleState(todoList));
				}else {					
					if(tick >= 0) {
						todoList.getTodoPanel().setTimerLabel(tick+"");
						time--;
					}else{
						todoList.getTodoPanel().setTimerLabel(tick+"");
						timer.cancel();
						todoList.setMyState(new RestState(todoList));
					}
				}
			}
		}
		timer.schedule(new TimerTasks(), 0, 1000);
		System.out.println("ok");
	}

}
