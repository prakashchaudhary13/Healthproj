package defaultpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateTable1
 */
@WebServlet("/CreateTable1")
public class CreateTable1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTable1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Connection con=null;
			try{
			     Class.forName("oracle.jdbc.driver.OracleDriver");
			     System.out.println("Driver Found");
			}
			catch(ClassNotFoundException e){
				System.out.println("Driver not found"+e);
			}
			try
			{
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			 System.out.println("Connection successful");
			}catch(SQLException e){
				System.out.println("Something went wrong in connection"+e);
			}
			PreparedStatement pt=con.prepareStatement("create table users(username varchar(20),age int,phone varchar(30),gender varchar(10),email varchar(45),password varchar(10),primary key(phone))");
			pt.executeUpdate();
	        System.out.println("Created");
		}catch(Exception e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
