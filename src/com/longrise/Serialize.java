package com.longrise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wujiaqi
 */
class Serialize implements Serializable {
	private static final long serialVersionUID = 3423503170972450054L;
	public int num = 1390;
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("D:serialize.bat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Serialize serialize = new Serialize();
		oos.writeObject(serialize);
		oos.flush();
		oos.close();
	}
}
