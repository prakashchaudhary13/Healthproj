package com.semester.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String age1 = request.getParameter("age");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User ur = new User();
		ur.setusername(username);
		try{
		if(username.isEmpty() || phone.isEmpty() || gender.isEmpty()|| email.isEmpty() || password.isEmpty() || age1.isEmpty())
		{
			System.out.println("error");
			//request.setAttribute("message","Fill out all the fields!!");
			out.println("<html>");
			out.println("<head>");
			out.println("<script src = 'sweetalert.min.js'></script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script>");
			out.println("sweetAlert('Oops','Fill out all the fields','error');");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request,response);
		}
		else if(phone.length()!=10)
		{
			System.out.println("error");
			//request.setAttribute("message","Fill out all the fields!!");
			out.println("<html>");
			out.println("<head>");
			out.println("<script src = 'sweetalert.min.js'></script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script>");
			out.println("sweetAlert('Oops','Phone number should be of 10 digits','error');");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request,response);
		}
		else if(password.length() > 10)
		{
			System.out.println("error");
			//request.setAttribute("message","Fill out all the fields!!");
			out.println("<html>");
			out.println("<head>");
			out.println("<script src = 'sweetalert.min.js'></script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script>");
			out.println("sweetAlert('Oops','Password should be of maximum 10 characters','error');");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request,response);
		}
		else{
			int age = 0;
			
			try{
				age = Integer.parseInt(age1);
			}catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
			ur.setAge(age);
			ur.setPhone(phone);
			ur.setGender(gender);
			ur.setEmail(email);
			ur.setPassword(password);
		if(ur.insert(ur)!=0)
		//request.setAttribute("SuccessMessage","Registered Successfully,login to continue!!");
		{
		System.out.println("Registered");
		out.println("<html>");
		out.println("<head>");
		out.println("<script src = 'sweetalert.min.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script>");
		out.println("sweetAlert('Registration','Successful!!','success');");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
		//request.setAttribute("SuccessMessage","Registered Successfully,login to continue!!");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request,response);
		}
		}
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
	}

}
