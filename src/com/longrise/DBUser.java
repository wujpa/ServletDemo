package com.longrise;

import java.util.ArrayList;
import java.util.List;

public class DBUser {
	public static final List<Users> users = new ArrayList<>();

	static {
		users.add(new Users("aaa","111"));
		users.add(new Users("bbb","222"));
		users.add(new Users("ccc","333"));
	}

	public static Users find(String username, String password){
		for (Users user:users){
			if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
}
