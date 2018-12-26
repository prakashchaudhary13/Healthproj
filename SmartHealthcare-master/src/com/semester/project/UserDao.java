package com.semester.project;



public interface UserDao {
	public int insert(User u);
	public User getCustomer(String email,String pass);
	public User getPhoneno(String uname);

}
