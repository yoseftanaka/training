package setting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class SerializerTemplate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4321877531482525978L;
	protected FileOutputStream fileout;
	protected ObjectOutputStream objectOutputStream;
	protected FileInputStream filein;
	protected ObjectInputStream objectInputStream;
	
	public void saveData(SerializerTemplate serializerTemplate) {
		
		try {
			setFileoutTarget();
			objectOutputStream = new ObjectOutputStream(fileout);
			objectOutputStream.writeObject(serializerTemplate);
			objectOutputStream.close();
			fileout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void obtainData() {
		try {
			setFileinTarget();
			objectInputStream = new ObjectInputStream(filein);
			readFromFile();
			objectInputStream.close();
			filein.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected abstract void setFileoutTarget() throws Exception;
	protected abstract void setFileinTarget() throws Exception;
	protected abstract void readFromFile() throws Exception;
}
