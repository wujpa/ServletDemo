package entity;

public class MyUser {
	private String stuname;
	private int age;
	private String stuid;
	private String password;

	public MyUser(String stuid, String stuname, int age, String password) {
		this.stuname = stuname;
		this.age = age;
		this.stuid = stuid;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
}
