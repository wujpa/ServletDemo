package com.longrise;

import java.util.LinkedHashMap;

public class DB {
	private static LinkedHashMap<String,Book> linkedHashMap = new LinkedHashMap<>();


	static {
		linkedHashMap.put("1",new Book("1","javaweb","wu"));
		linkedHashMap.put("2",new Book("2","java","jia"));
		linkedHashMap.put("3",new Book("3","oracle","qi"));
		linkedHashMap.put("4",new Book("4","mysql","q"));
		linkedHashMap.put("5",new Book("5","ajax","o"));
	}

	public static LinkedHashMap getAll(){
		return linkedHashMap;
	}
}
