package task.state;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import composite.TodoList;
import main.Main;
import setting.ConfigSerializer;
import setting.PointSerializer;

public class RestState extends TaskState {
	
	private ConfigSerializer configSerializer = ConfigSerializer.getInstance();
	private PointSerializer pointSerializer = PointSerializer.getInstance();
	private int time = configSerializer.getRestMinute()*60+configSerializer.getRestSecond();
	public RestState(TodoList todoList) {
		super(todoList);
		resting();
	}
	public void resting() {
		Timer timer = new Timer();
		class TimerTasks extends TimerTask {
			public void run() {
				int tick = time;
				if(!Main.isTaskStarted) {
					todoList.getTodoPanel().interruptTimer();
					timer.cancel();
					todoList.setMyState(new IdleState(todoList));
				}else {					
					if(tick > 0) {
						todoList.getTodoPanel().setTimerLabel(tick+"");
						time--;
					}else{
						todoList.getTodoPanel().setTimerLabel(tick+"");
						timer.cancel();
						todoList.setMyState(new IdleState(todoList));
						Main.isTaskStarted = false;
						Main.refresh();
					}
				}
			}
		}
		todoList.getTodoPanel().setTimerColor(Color.GREEN);
		timer.schedule(new TimerTasks(), 0, 1000);
		System.out.println("ok");
	}

}
