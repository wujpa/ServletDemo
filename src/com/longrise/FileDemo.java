package com.longrise;

import java.io.*;

/**
 * @author wujiaqi
 */
public class FileDemo {
	public static void main(String[] args) {
		File file = new File("D:serialize.bat");
		try {
			InputStream in;
			if(file.exists()){
				in = new FileInputStream(file);
				//装饰器
				InputStream in1 = new BufferedInputStream(new FileInputStream(file));
				InputStreamReader inputStreamReader = new InputStreamReader(in);
//				BufferedReader br = new BufferedReader(inputStreamReader);
				int len = 0;
				while ((len = inputStreamReader.read()) != -1){
					System.out.println(len);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
