package com.semester.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String submit = request.getParameter("submit");
		User u = ud.getCustomer(email, password);
		PrintWriter out = response.getWriter();
		
		if(submit.equals("login") && u!=null && u.getEmail()!=null)
		{
			System.out.println("logged in");
			HttpSession session = request.getSession();
			session.setAttribute("username",u.getusername());
			request.setAttribute("message",u.getusername());
		/*	out.println("<html>");
			out.println("<head>");
			out.println("<script src = 'sweetalert.min.js'></script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script>");
			out.println("sweetAlert('Logged in','Connected','success');");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>"); */
			request.getRequestDispatcher("index4.html").forward(request,response);
		}
		else
		{
			System.out.println("error");
			//request.setAttribute("message","Fill out all the fields!!");
			out.println("<html>");
			out.println("<head>");
			out.println("<script src = 'sweetalert.min.js'></script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script>");
			out.println("sweetAlert('Details not found','Please register first','error');");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request,response);
		}
		
		
		
	}

}
