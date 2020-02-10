package setting;


import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ConfigSerializer extends SerializerTemplate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2755699474908475147L;
	/**
	 * 
	 */
	private static ConfigSerializer configSerializer;
	private int workMinute;
	private int workSecond;
	private int restMinute;
	private int restSecond;
	
	private ConfigSerializer() {
		obtainData();
		
	}
	
	public static ConfigSerializer getInstance() {
		if( configSerializer ==null) new ConfigSerializer();
		System.out.println("passed: "+configSerializer);
		return configSerializer;
	}

	public int getWorkMinute() {
		return workMinute;
	}

	public void setWorkMinute(int workMinute) {
		this.workMinute = workMinute;
	}

	public int getWorkSecond() {
		return workSecond;
	}

	public void setWorkSecond(int workSecond) {
		this.workSecond = workSecond;
	}

	public int getRestMinute() {
		return restMinute;
	}

	public void setRestMinute(int restMinute) {
		this.restMinute = restMinute;
	}

	public int getRestSecond() {
		return restSecond;
	}

	public void setRestSecond(int restSecond) {
		this.restSecond = restSecond;
	}

	@Override
	protected void setFileoutTarget() throws Exception {
		// TODO Auto-generated method stub
		this.fileout = new FileOutputStream("config.ser",false);
	}

	@Override
	protected void setFileinTarget() throws Exception {
		// TODO Auto-generated method stub
		this.filein = new FileInputStream("config.ser");
	}
	
	@Override
	protected void readFromFile() throws Exception {
		// TODO Auto-generated method stub
		configSerializer = (ConfigSerializer)this.objectInputStream.readObject();
	}
	
	

}
