package com.semester.project;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class User {
	private String username;
	private String email;
	private String gender;
	private int age;
	private String password;
	private String phone;
	public String username() {
		return username;
	}
	public void setusername(String uname) {
		this.username=uname;
	}
	public String getusername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int insert(User u) {
		int status = 0;
		try{
			Connection con=null;
			
			con = MyConnectionProvider.getCon();
	        PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			ps.setString(1,u.getusername());
			ps.setInt(2, u.getAge());
			ps.setString(3, u.getPhone());
		    ps.setString(4,u.getGender());
		    ps.setString(5,u.getEmail());
		    ps.setString(6,u.getPassword());
		    status = ps.executeUpdate();
			con.close();
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

}
