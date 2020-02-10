package setting;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PointSerializer extends SerializerTemplate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8237979247561085665L;
	private static PointSerializer pointSerializer;
	private int point;
	
	private PointSerializer() {
		obtainData();
	}
	
	public static PointSerializer getInstance() {
		if(pointSerializer==null) new PointSerializer();
		System.out.println("passed point: "+ pointSerializer);
		return pointSerializer;
	}
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	protected void setFileoutTarget() throws Exception {
		// TODO Auto-generated method stub
		this.fileout = new FileOutputStream("point.ser",false);
	}

	@Override
	protected void setFileinTarget() throws Exception {
		// TODO Auto-generated method stub
		this.filein = new FileInputStream("point.ser");
	}

	@Override
	protected void readFromFile() throws Exception {
		// TODO Auto-generated method stub
		pointSerializer = (PointSerializer) this.objectInputStream.readObject();
	}
	
	

}
