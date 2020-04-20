package dao;

import entity.MyUser;
import util.JDUtil;
import util.MD5Util;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class UserDaoImplement implements UserDao{
	@Override
	public boolean login(String name, String password) {
		boolean flag = false;
		String sql = "select * from student where stuname = ? and password = ?";
		Object[] o = new Object[2];
		password = MD5Util.getInstance().encodeByMD5(password);
		o[0] = name;
		o[1] = password;
		JDUtil.update(sql,o);

		return true;
	}

	@Override
	public boolean register(MyUser myUser) {
		String sql = "INSERT INTO STUDENT ('STUID','STUNAME','AGE','PASSWORD') VALUES(?,?,?,?)";
		Object[] o = new Object[4];
		o[0] = myUser.getStuid();
		o[1] = myUser.getStuname();
		o[2] = myUser.getAge();
		o[3] = MD5Util.getInstance().encodeByMD5(myUser.getPassword());
		JDUtil.update(sql,o);
		return true;
	}

	@Override
	public List<MyUser> getUserAll() {
		return null;
	}

	@Override
	public boolean delete(String stuid) {
		return false;
	}

	@Override
	public boolean update(String stuid, String name) {
		return false;
	}
}
