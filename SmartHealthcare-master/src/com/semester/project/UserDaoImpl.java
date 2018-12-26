package com.semester.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class UserDaoImpl implements UserDao {

	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insert(User u) {
		int status = 0;
		try{
			
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			ps.setString(1,u.getusername());
			ps.setInt(2, u.getAge());
			ps.setString(3, u.getPhone());
		    ps.setString(4,u.getGender());
		    ps.setString(5,u.getEmail());
		    ps.setString(6, u.getPassword());
		    status = ps.executeUpdate();
			con.close();
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User getCustomer(String email, String pass) {
		User u = new User();
		try{
			con = MyConnectionProvider.getCon();
			 ps=con.prepareStatement("select * from users where email =? and password =?");
	    	 ps.setString(1,email);
	    	 ps.setString(2,pass);
	    	 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 u.setusername(rs.getString(1));
				 u.setAge(rs.getInt(2));
				 u.setPhone(rs.getString(3));
				 u.setGender(rs.getString(4));
				 u.setEmail(rs.getString(5));
				 u.setPassword(rs.getString(6));
			 }
	    	 
	    	 
	    	 
		   }catch(Exception e)
		{
			   System.out.println(e);
		}
		return u;
	}

	@Override
	public User getPhoneno(String uname) {
		
		
		User u = new User();
		try{
			con = MyConnectionProvider.getCon();
			 ps=con.prepareStatement("select * from users where username = ?");
	    	 ps.setString(1,uname);
	    	 //ps.setString(2,pass);
	    	 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 u.setusername(rs.getString(1));
				 u.setAge(rs.getInt(2));
				 u.setPhone(rs.getString(3));
				 u.setGender(rs.getString(4));
				 u.setEmail(rs.getString(5));
				 u.setPassword(rs.getString(6));
			 }
	    	 
	    	 
	    	 
		   }catch(Exception e)
		{
			   System.out.println(e);
		}
		return u;
	}

}
