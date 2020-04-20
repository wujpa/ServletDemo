package dao;

import entity.MyUser;

import java.util.List;

public interface UserDao {
	boolean login(String name, String password);
	boolean register(MyUser myUser);
	List<MyUser> getUserAll();
	boolean delete(String stuid);
	boolean update(String stuid, String name);
}
